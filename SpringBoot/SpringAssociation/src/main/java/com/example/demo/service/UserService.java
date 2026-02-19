package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import com.example.demo.exception.ProfileAlreadyExistsException;
import com.example.demo.exception.ResourseNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository profileRepo;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("User not found: " + id));
	}

	public User updateUser(Long id, User update) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("User not found: " + id));

		user.setName(update.getName());
		user.setEmail(update.getEmail());

		UserProfile profile = user.getUserProfile();
		profile.setAddress(update.getUserProfile().getAddress());
		profile.setPhoneNumber(update.getUserProfile().getPhoneNumber());

		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("User not found: " + id));

		userRepository.delete(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public Object addProfileToUser(Long id, UserProfile userProfile) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("User not found: " + id));

		if (user.getUserProfile() != null) {
			throw new ProfileAlreadyExistsException("Profile already exists for this user");
		}

		UserProfile profile = new UserProfile();
		profile.setAddress(userProfile.getAddress());
		profile.setPhoneNumber(userProfile.getPhoneNumber());
		profile.setUser(user);
		user.setUserProfile(userProfile);

		return userRepository.save(user);
	}

	public User updateProfile(Long userId, UserProfile profile) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User not found: " + userId));

		UserProfile userProfile = user.getUserProfile();
		if (userProfile == null) {
			throw new ResourseNotFoundException("Profile not created yet");
		}

		userProfile.setAddress(profile.getAddress());
		userProfile.setPhoneNumber(profile.getPhoneNumber());

		profileRepo.save(userProfile);
		return user;
	}

	public UserProfile getProfile(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User not found: " + userId));

		UserProfile userProfile = user.getUserProfile();
		if (userProfile == null) {
			throw new ResourseNotFoundException("Profile not found for user with id: " + userId);
		}

		return userProfile;
	}

	public UserProfile deleteProfile(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User not found: " + userId));

		UserProfile userProfile = user.getUserProfile();
		if (userProfile == null) {
			throw new ResourseNotFoundException("Profile not found for user with id: " + userId);
		}
		user.setUserProfile(null);
		userRepository.save(user);

		profileRepo.delete(userProfile);
		return userProfile;
	}

	public List<User> getUsersByEmail(String email) {
	    List<User> users = userRepository.findByEmail(email);

	    if (users.isEmpty()) {
	        throw new ResourseNotFoundException("No users found with email: " + email);
	    }
	    return users;
	}
	
	public List<UserProfile> getProfilesByAddress(String address) {
	    List<UserProfile> profile = profileRepo.findByAddress(address);

	    if (profile.isEmpty()) {
	        throw new ResourseNotFoundException("No profiles found in address: " + address);
	    }
	    return profile;
	}
}
