package za.ac.cput.domain;

public class Student {
    private String studentNumber;
    private String studentName;
    private GenderType gender;

    public Student() {
    }
    //    Builder Constractor
    public Student(Builder builder) {
        this.studentNumber = builder.studentNumber;
        this.studentName = builder.studentName;
        this.gender = builder.gender;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                '}';
    }

    //    Builder Class
    public static class Builder {
        private String studentNumber;
        private String studentName;
        private GenderType gender;

        public Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }
        public Builder setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }
        public Builder setGender(GenderType gender) {
            this.gender = gender;
            return this;
        }
        public Builder copy(Student student){
            this.studentNumber = student.studentNumber;
            this.studentName = student.studentName;
            this.gender = student.gender;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
}
