/*
 * Practical Exam: Elementary Chatbot
 * Application: Online Shopping Customer Support Chatbot
 * Type: Rule-Based (Keyword Matching using if-else)
 * Language: Java
 */

import java.util.Scanner;

public class ShoppingChatbot {

    public static String getResponse(String input) {

        input = input.toLowerCase(); // case-insensitive matching

        // 1. Greeting
        if (input.contains("hello") || input.contains("hi") || input.contains("hey")) {
            return "Hi there! Welcome to QuickShop. How can I help you today?";
        }

        // 2. Order status
        else if (input.contains("order") && input.contains("status")
               || input.contains("where is my order") || input.contains("track")) {
            return "You can track your order in the 'My Orders' section. "
                 + "Live tracking is available once the item is shipped.";
        }

        // 3. Return / Refund
        else if (input.contains("return") || input.contains("refund")) {
            return "Returns are accepted within 7 days of delivery. "
                 + "Go to 'My Orders', select the item, and click 'Return'. "
                 + "Refund will be credited within 5-7 business days.";
        }

        // 4. Cancel order
        else if (input.contains("cancel")) {
            return "You can cancel your order before it is shipped. "
                 + "Go to 'My Orders' and click 'Cancel Order'.";
        }

        // 5. Delivery / Shipping
        else if (input.contains("delivery") || input.contains("shipping")) {
            return "Standard delivery takes 3-5 business days. "
                 + "Express delivery (1-2 days) is available for Prime members.";
        }

        // 6. Payment
        else if (input.contains("payment") || input.contains("pay")) {
            return "We accept UPI, Credit/Debit Cards, Net Banking, "
                 + "and Cash on Delivery. EMI options are also available.";
        }

        // 7. Discount / Coupon / Offer
        else if (input.contains("discount") || input.contains("coupon")
               || input.contains("offer")) {
            return "Check the 'Deals' section for today's offers. "
                 + "Use code SAVE10 for 10% off on your first order!";
        }

        // 8. Account / Login
        else if (input.contains("account") || input.contains("login")
               || input.contains("password")) {
            return "For login issues, click 'Forgot Password' on the login page. "
                 + "A reset link will be sent to your registered email.";
        }

        // 9. Complaint / Issue
        else if (input.contains("complaint") || input.contains("problem")
               || input.contains("damaged") || input.contains("wrong item")) {
            return "Sorry for the trouble! Please raise a complaint in "
                 + "'My Orders' > 'Report a Problem'. "
                 + "Our team will contact you within 24 hours.";
        }

        // 10. Goodbye
        else if (input.contains("bye") || input.contains("exit")
               || input.contains("quit")) {
            return "QUIT";
        }

        // Default fallback
        else {
            return "I am not sure about that. You can ask me about: "
                 + "order tracking, returns, refunds, delivery, payment, "
                 + "discounts, account issues, or complaints.";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("  QuickShop - Customer Support  ");
        System.out.println("================================");
        System.out.println("Type 'bye' to exit.\n");

        while (true) {

            System.out.print("You: ");
            String userInput = sc.nextLine();

            if (userInput.trim().isEmpty()) {
                continue;
            }

            String response = getResponse(userInput);

            if (response.equals("QUIT")) {
                System.out.println("Bot: Thanks for shopping with us. Have a great day!");
                break;
            }

            System.out.println("Bot: " + response);
            System.out.println();
        }

        sc.close();
    }
}