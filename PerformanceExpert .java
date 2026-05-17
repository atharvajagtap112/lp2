/*
 * Practical Exam: Expert System
 * Application: Employee Performance Evaluation
 * Technique: Rule-Based / Forward Chaining
 * Language: Java
 *
 * Input Parameters:
 *   1. Task Completion Score  (0 - 100)
 *   2. Attendance Percentage  (0 - 100)
 *   3. Teamwork Score         (0 - 10)
 *   4. Target Achievement %   (0 - 100)
 *
 * Output: Performance Grade + Appraisal Recommendation
 */

import java.util.Scanner;

public class PerformanceExpert {

    // ── KNOWLEDGE BASE ──────────────────────────────
    // Rule 1: Calculate weighted overall score
    // Rule 2: Fire rules based on score range
    // Rule 3: Give recommendation based on grade
    // ─────────────────────────────────────────────

    public static String evaluatePerformance(
            int taskScore,
            int attendance,
            int teamwork,
            int targetAchieved) {

        // ── INFERENCE ENGINE ──────────────────────────
        // Weighted formula:
        //   Task Completion  → 40%
        //   Target Achieved  → 30%
        //   Attendance       → 20%
        //   Teamwork (x10)   → 10%
        // ─────────────────────────────────────────
        double overall = (taskScore * 0.40)
                       + (targetAchieved * 0.30)
                       + (attendance * 0.20)
                       + ((teamwork * 10) * 0.10);

        System.out.println("\n--- Evaluation Report ---");
        System.out.printf("Overall Score : %.2f / 100%n", overall);

        // ── RULE FIRING ───────────────────────────────

        if (overall >= 85) {
            System.out.println("Grade         : Excellent");
            System.out.println("Appraisal     : Promote + 30% Hike");
            return "Outstanding performer. Recommend for promotion.";
        }

        else if (overall >= 70) {
            System.out.println("Grade         : Good");
            System.out.println("Appraisal     : 15% Hike");
            return "Good performer. Eligible for increment.";
        }

        else if (overall >= 55) {
            System.out.println("Grade         : Average");
            System.out.println("Appraisal     : 5% Hike + Training Recommended");
            return "Average performer. Needs skill improvement.";
        }

        else if (overall >= 40) {
            System.out.println("Grade         : Below Average");
            System.out.println("Appraisal     : No Hike + Performance Improvement Plan");
            return "Below average. Must follow improvement plan.";
        }

        else {
            System.out.println("Grade         : Poor");
            System.out.println("Appraisal     : Termination Warning Issued");
            return "Poor performance. Immediate action required.";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("  Employee Performance Evaluation System");
        System.out.println("=======================================");

        System.out.print("Enter Employee Name        : ");
        String name = sc.nextLine();

        System.out.print("Task Completion Score(0-100): ");
        int task = sc.nextInt();

        System.out.print("Attendance Percentage(0-100): ");
        int attend = sc.nextInt();

        System.out.print("Teamwork Score       (0-10) : ");
        int team = sc.nextInt();

        System.out.print("Target Achieved %    (0-100): ");
        int target = sc.nextInt();

        System.out.println("\nEmployee : " + name);

        String result = evaluatePerformance(task, attend, team, target);

        System.out.println("Decision  : " + result);
        System.out.println("=======================================");

        sc.close();
    }
}