# Java Interview Questions

1. Test Case 1 -> Validate payment card number.
    * You can check the credit card number as follows on the controller.
   ![](../../../var/folders/vk/yg1hch_16k7ctrqk4gjvmszr0000gn/T/TemporaryItems/NSIRD_screencaptureui_C4lL80/Screen Shot 2023-06-19 at 22.36.00.png)
   URL : http://localhost:8080/validateCreditCard
   Example Request Body :
      {
      "cardNumber": "4556737586899855"
      }
    * Some test cases were written.
    ![](../Desktop/Screen Shot 2023-06-19 at 22.53.58.png)
   
2. Test Case 2 -> Create schedule for academic program
   * You can check add the academical program as specified below.
   ![](../../../var/folders/vk/yg1hch_16k7ctrqk4gjvmszr0000gn/T/TemporaryItems/NSIRD_screencaptureui_nhI3Ab/Screen Shot 2023-06-19 at 22.39.14.png)
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
   ![](../Desktop/Screen Shot 2023-06-19 at 22.56.06.png)