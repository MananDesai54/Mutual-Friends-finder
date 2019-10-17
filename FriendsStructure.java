import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
/*  to make the friend structure assuming that
*   you are able to send friend requests to others like suggested friends or anyone
*   and you can un-friend anyone you want and randomly it will be selected or won't be selected
*/

/*
*   project by
*       MANAN DESAI (CE_C-025)
*       DHAVAL CHAVDA (CE_C-023)
*/
public class FriendsStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int v = scanner.nextInt();
        Graph g = new Graph(v);
        System.out.println("Add friends and to stop press -1");
        System.out.println("Enter two number to create edge between them:");
        int i = 0;
        int u1 = 0;
        int u2 = 0;
        while (i != -1) {
            u1 = scanner.nextInt();
            if (u1 == -1 || u2 == -1)
                break;
            u2 = scanner.nextInt();
            g.addEdge(u1, u2);
            g.addEdge(u2, u1);
        }
        System.out.println("select your starting node:");
        int start = scanner.nextInt();
        int choise = 0;
        int n1;
        int n2;
        System.out.println("\nselect choise from below:\n1.want to see mutual friend of two of your friend structure.\n2.want to see suggested friend o use from your friend structure.");
        choise = scanner.nextInt();
        switch (choise) {
            case 1:
                System.out.println("Enter two number between whom you want to see mutual friends.");
                System.out.println("You can select from this : ");
                g.BFS(start);
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                int[] c = g.mutualFriend(n1, n2);
                if (c.length > 0) {
                    System.out.println("Total mutual friends are " + c.length);
                    for (int n : c)
                        System.out.print(n + " ");
                } else {
                    System.out.println("No mutual friends present.");
                }
                System.out.println();
                break;
            case 2:
                System.out.println("Enter number whose suggested friend should be displayed: ");
                System.out.println("You can select from this : ");
                g.BFS(start);
                n1 = scanner.nextInt();
                g.suggestedFriend(n1);
        }
    }
}
