package fr.kaibee.cleancode.temporalcoupling;

import java.util.Random;

/**
 * Here we need to make student pass test.
 * But we need to get the test first...
 * But to get the test we need to get the student level...
 *
 * What can we change in methods
 * evaluate, fetchStudentLevel, fetchMatchingTest and passingTest to explicit this temporal coupling ?
 */
public class CourseAssessment {

    public TestResult evaluate(Student student, Course course) {
        Level level = fetchStudentLevel(student); // Student -> level
        Test test = fetchMatchingTest(course, level); // Course, level -> Test
        return passingTest(student, test); // Student, Test -> TestResult
    }

    private TestResult passingTest(Student student, Test test) {
        return student.passes(test);
    }

    private Test fetchMatchingTest(Course course, Level level) {
        return new Test(course.getName() + "_" + level.name());
    }

    private Level fetchStudentLevel(Student student) {
        return switch (student.getExp()) {
            case 1 -> Level.BEG;
            case 2 -> Level.INTER;
            default -> Level.MASTER;
        };
    }

    private static class Course {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class Student {
        private int exp;

        public TestResult passes(Test test) {
            return new Random().nextInt() % 2 == 0 ? TestResult.SUCCESS : TestResult.FAILURE;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }
    }

    private enum Level {
        INTER, MASTER, BEG
    }

    private static class Test {
        private final String id;

        public Test(String id) {
            this.id = id;
        }
    }

    private enum TestResult {
        FAILURE, SUCCESS
    }
}

