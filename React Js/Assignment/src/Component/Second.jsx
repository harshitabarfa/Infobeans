import React, { useState } from 'react';

function Second() {
    const [isVisible, setIsVisible] = useState(false);

    const toggleMessage = () => {
        setIsVisible(!isVisible);
    };

    return (
        <div>
            <button onClick={toggleMessage}>
                {isVisible ? 'Hide Message' : 'Show Message'}
            </button>
            {isVisible && <p>Hello, welcome to React!</p>}
        </div>
    );
};

export default Second
