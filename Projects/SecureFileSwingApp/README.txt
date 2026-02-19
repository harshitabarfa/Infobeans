
Secure File Access & Sharing System — Swing Edition (No DB)
-----------------------------------------------------------
How to run (requires JDK 11+):
Windows:
  1) Double-click run.bat   (or open cmd here and run: run.bat)
macOS / Linux:
  1) chmod +x run.sh
  2) ./run.sh

What this is:
  - A clean Swing UI that implements:
      * Sign Up / Login
      * Roles: Admin/User
      * Upload files (stored under app_data/storage)
      * Share files with users
      * Notifications & Activity Log
  - Persistence is file-based (JSON under app_data/) so it runs out of the box.
  - No external libraries.

Default admin account (preloaded):
  username: admin
  password: admin123

Storage:
  - Files you upload are copied into app_data/storage.
  - Metadata lives in app_data/*.json

Notes:
  - This is a fresh Swing front-end + service layer to be "ready to run".
  - If you want to point it to your MySQL later, you can replace the Repo classes
    with JDBC-backed ones; the UI layer is separated for that.
