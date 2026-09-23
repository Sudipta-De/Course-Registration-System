# Course Registration System

Java Swing Course Registration System with programme-based course management, student account management, inline duplicate validation, and local data persistence.

## Features
- Admin CRUD for programmes, students, and courses
- Courses are created and managed under a selected programme
- Protected default courses cannot be deleted
- Student IDs and usernames are checked while typing
- Duplicate warnings appear directly below Student ID and Username fields
- Students log in with Programme + Username + Password
- Students can change their own username and password
- Admin can reset a student's password but never view the existing password
- Passwords are stored as SHA-256 hashes rather than plain text
- Student registration, withdrawal, and course-capacity checks
- Data saved locally in `CRSData.ser`

## Run
Java 8+ is required; Java 17+ is recommended.

```bash
java -jar Course-Registration-System-GUI.jar
```

Default admin login: `admin` / `admin01`

Do not commit `CRSData.ser` if it contains personal or test data.
