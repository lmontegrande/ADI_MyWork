package com.company;

/** This is created to be independant practice for working with dataTypes variables. Data sources are found at the below the class **/

public class Main {

    public static void main(String[] args) {

        // TODO: Complete the following variable declarations.

        int oldYear = 1950;
        int nowYear = 2016;

        float averageFamilyIncome1950 = 3_300;
        float medianHomePrice1950 = 7_354;
        float tuitionYale1950 = 600;
        float roomAndBoardYale1950 = 456;
        float otherExpensesYale1950 = 376;

        float averageFamilyIncome2015 = 51_017;
        float medianHomePrice2015 = 188_900;
        float medianHomePriceManhattan2013 = 855_000;
        float tuitionYale2015 = 45_800;
        float roomAndBoardYale2015 = 14_000;
        float otherExpensesYale2015 = 5_552;

        String intro = "To understand how purchasing power has changed in the past 65 years, it is useful to compare the family income to the cost of goods and services, such as housing and education.";


        // TODO: Find and fix a mistake in the following.

        if (intro == "A long time ago in a galexy far, far away") {
            System.out.println("May the force be with you.");
        }
        else {
            System.out.println(intro);
        }

        // TODO: Use a print statment to add a newline or <br>.
        System.out.println("Test 1: \n");

        // TODO: Complete the following basic mathematical calculations.
        float homeRatio1950 = medianHomePrice1950 / averageFamilyIncome1950;
        float homeRatio2015 = medianHomePrice2015 / averageFamilyIncome2015;
        float homeRationNYC2015 = medianHomePriceManhattan2013 / averageFamilyIncome2015;

        System.out.println("Test 2: ");
        System.out.println("1950: " + homeRatio1950);
        System.out.println("2015: " + homeRatio2015);

        // Divide median home price by annual income and print each result to the command line.
        // Make 3 variables: homeRatio1950, homeRatio2015, homeRatioNYC2015

        // Find the total cost of university education for 1950 and for 2015 and print result to the command line.
        // Then divide university cost by annual income for both: educationRatio1950, & educationRation2015. Print the results to the command line.

        // TODO: Convert the following String into a number.

        String averageDebt1950 = "2000";
        float converted1950 = (float)Integer.parseInt(averageDebt1950);

        // TODO: Complete the following variable declarations, find the typo, and replace the /*something*/'s in the String with the proper variables.

        float creditCardDebt2010 = 15_355;
        float totalDebt2010 = 129579;
        String debt = "Debt is an unwelcome guest at the table in many American households. Back in the late 1940s and early 1950s, the average American consumer had less than " + averageDebt1950 + " in total personal debt. Today the average U.S. household with debt carries " + creditCardDebt2010 + " in credit card debt and " + totalDebt2010 + " in total debt.";

        // TODO: Using one line of code, determine if the following string contains the word "table". Print the result to the command line.

        System.out.println("Test 3: " + debt.contains("table"));

        // TODO: How has the ratio of debt to income changed in the past 60 years?
        float Ratio1950 = averageFamilyIncome1950 / converted1950;
        float Ratio2010 = averageFamilyIncome2015 / totalDebt2010;

        // EXTRA: Round the answer to two decimal places.
    }
}

/** SOURCES:
 *  http://www.mybudget360.com/cost-of-living-2014-inflation-1950-vs-2014-data-housing-cars-college/
 *  http://oir.yale.edu/1701-1976-yale-book-numbers
 *  http://www.yale.edu/tuba/finaid/finaid-information/1516/1516EA_FYYE.pdf
 *  http://www.forbes.com/sites/erincarlyle/2014/01/30/manhattan-real-estate-ten-year-review-neighborhoods-where-prices-have-gone-up-the-most/
 *  https://www.mainstreet.com/article/americans-personal-debt-skyrockets
 *  http://www.nerdwallet.com/blog/credit-card-data/average-credit-card-debt-household/
 *  **/
