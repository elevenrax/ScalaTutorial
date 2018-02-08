/**
  *  The purpose of this is not to produce ground breaking Scala, but rather to demonstrate
  *  subtle differences between Scala and Java in the OO Space.
  */
object ScalaTutorial {

    def main(args: Array[String]): Unit = {

        // Sample Students
        val maria = new Student("Maria T", "Computer Science")
        printf(s"${maria.getName} with id ${maria.id} studies ${maria.getProgram}\n")

        val leon = new Student("Leon W", "History and Literature")
        printf(s"${leon.getName} with id ${leon.id} studies ${leon.getProgram}\n")

        val lara = new Student("Lara S", "Film and Photography")
        printf(s"${lara.getName} with id ${lara.id} studies ${lara.getProgram}\n")



        // Add Students to an Array
        var enroledStudents = Array(maria, leon)

        // Iterate over Students and add their names to an Array
        val namesOfEnrolledStudents =
            for (student <- enroledStudents) yield student.getName

        // Iterate over the new array of strings and print their names
        println("We have enrolled:")
        for (name <- namesOfEnrolledStudents)
            println(name)

    }


    /**
      * A Class for students.
      *
      * @param name
      * @param program
      */
    class Student(var name: String, var program: String) {


        // Auxiliary Constructors
        def this(name : String) {
            this(name, "No Program")
        }

        def this() {
            this("No Name", "No Sound")
        }

        // ID set statically
        val id = Student.newIdNumber


        // Getters and Setters
        def getName() : String = name
        def getProgram() : String = program

        def setName(name : String): Unit = {
            // Regex Validation to reject invalid names
            if (!(name.matches(".*\\d+.*")))
                this.name = name
            else
                this.name = "No Match"
        }

        def setProgram(program : String): Unit = {
            this.program = program
        }

        override def toString: String = {
            return "%s with the id %d studies %s".format(this.name, this.id, this.program)
        }
    }

    /**
      *  A "Static Method" In Java Parlance for the `Student` Class.
      *  NB. Notice there is no return statement.
      *      Scala automatically returns the last variable
      */
    object Student {
        private var idNumber = 0
        private def newIdNumber = {
            idNumber += 1; idNumber
        }
    }


}