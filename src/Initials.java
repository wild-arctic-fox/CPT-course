/**
 * This class demonstrates first java application
 *
 * @author Veprytska Alyona  o.veprytska@student.csn.khai.edu
 * @version 1.0
 * @since 2020-07-09
 */
public class Initials {
    /**
     * This method demonstrates student information
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        String personalData = "Group: 545a\n" +
                              "Student: Veprytska Alyona Yuriivna\n" +
                              "Variant: 2\n";

        String initials =   "**       **     ***     **       **\n" +
                            "**       **    ** **     **     ** \n" +
                            "**       **   **   **     **   **  \n" +
                            "**       **  **     **     ** **   \n" +
                            " **     **  ** ***** **     ***    \n" +
                            "  **   **   **       **     ***    \n" +
                            "   ** **    **       **     ***    \n" +
                            "    ***     **       **     ***    \n";

        System.out.println(personalData);
        System.out.println(initials);
    }
}
