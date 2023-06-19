# Java Interview Questions

1. Test Case 1 -> Validate payment card number.
    * You can check the credit card number as follows on the controller.
   URL : http://localhost:8080/validateCreditCard
   Example Request Body :
      {
      "cardNumber": "4556737586899855"
      }
    * Some test cases were written.
   
2. Test Case 2 -> Create schedule for academic program.
   * You can check add the academical program as specified below.
   URL : http://localhost:8080/getScheduledProgram
   Example Request Body :
     {
     "totalCourseNumber" : 8,
     "courses" : [
     {
     "courseNo" : 4,
     "prerequisites": [0, 2]
     },
     {
     "courseNo" : 0,
     "prerequisites": [1,6]
     },
     {
     "courseNo" : 2,
     "prerequisites": [3,7]
     },
     {
     "courseNo" : 1,
     "prerequisites": [5]
     },
     {
     "courseNo" : 6,
     "prerequisites": [5]
     },
     {
     "courseNo" : 3,
     "prerequisites": [5]
     },
     {
     "courseNo" : 7,
     "prerequisites": [5]
     }
     ]
     }
   * Some test cases were written.