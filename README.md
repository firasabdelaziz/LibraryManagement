# Library Management Backend Application in 1:30h 📚🚀

Dive into our briskly developed library management system, created in just 1 hour and 30 minutes! 🕒

## Part I: Database Schema

We've crafted a MySQL database schema encompassing dynamic entities such as LibraryCard, Student, Reservation, Status (ACTIVE/EXPIRED), Author, and Book. Identifiers are seamlessly generated with a touch of automation.

## Part II: Services and REST Controllers

Explore our meticulously orchestrated Spring services, seamlessly exposed as RESTful endpoints. Here's a sneak peek into the features:

1. **Dynamic Author Management**
   - Utilize the `addAuthor` method to seamlessly add authors with unique identifiers.

2. **Efficient Student Registration**
   - Swiftly register students using the `addStudent` method, complete with active library cards.

3. **Instantaneous Book Integration**
   - Add and assign books to authors with lightning speed using `addBookAndAssignToAuthor`.

4. **Effortless Student-to-Book Assignment**
   - Magically assign students to books through the `assignStudentToBook` method, automatically creating reservations.

5. **Success-Driven Aspect**
   - Each operation concludes with a success message, dynamically presented through an aspect for a streamlined user experience.

6. **Library Card Status Exploration**
   - Easily retrieve a list of students based on their library card status with the `retrieveStudentsByStatus` method.

7. **Author-Inspired Student Listing**
   - Explore students who have reserved books from a specific author using the `retrieveStudentsByAuthorName` method.

8. **Automated Status Update**
   - Leverage Spring Scheduler to automatically update library card statuses after 30 seconds with `updateStatusLibraryCard`.

Embark on a journey through our source code to uncover the simplicity and efficiency embedded in this swift library management system! 🚀✨
