package meddtg.bit.assignment2;

/**
 * This class holds all the data for the questions which is taken to the main java class to be sorted
 * into questions
 */
public class Questions {
    public String ques;
    public String img;
    public String ans1;
    public String ans2;
    public String ans3;
    public String ans4;
    public Questions(int i)
    {
        switch(i) {
            case 0:
                ques = "What City or Town is This Sign in?";
                ans1 = "Mosgiel";
                ans2 = "Dunedin";
                ans3 = "Wellington";
                ans4 = "Naseby";
                break;
            case 1:
                ques = "Which Of these Cities is the Furthest to the south?";
                ans1 = "Invercargill";
                ans2 = "Dunedin";
                ans3 = "Auckland";
                ans4 = "Christchurch";
                break;
            case 2:
                ques = "What is the name of the largest city in the South Island?";
                ans1 = "Christchurch";
                ans2 = "Canterbury";
                ans3 = "Culverden";
                ans4 = "Cromwell";
                break;
            case 3:
                ques = "What is the largest city in New Zealand?";
                ans1 = "Auckland";
                ans2 = "Christchurch";
                ans3 = "Hamilton";
                ans4 = "Wellington";
                break;
            case 4:
                ques = "What is the northern-most town in New Zealand?";
                ans1 = "Kaitaia";
                ans2 = "Rotorua";
                ans3 = "Kerikeri";
                ans4 = "Whangerei";
                break;
            case 5:
                ques = "What city is the adventure sports capital of the world?";
                ans1 = "Queenstown";
                ans2 = "Akaroa";
                ans3 = "Blackball";
                ans4 = "Greymouth";
                break;
            case 6:
                ques = "Which town is the main port of the South Island?";
                ans1 = "Lyttelton";
                ans2 = "Westport";
                ans3 = "Seafield";
                ans4 = "Timaru";
                break;
            case 7:
                ques = "Whats the easternmost city in New Zealand?";
                ans1 = "Gisborn";
                ans2 = "Greytown";
                ans3 = "Greymouth";
                ans4 = "Greerton";
                break;
            case 8:
                ques = "What is the name of the largest inland city in New Zealand?";
                ans1 = "Hamilton";
                ans2 = "Hawera";
                ans3 = "Huntly";
                ans4 = "Hunterville";
                break;
            case 9:
                ques = "What town is world famous in New Zealand because it has a soft drink named after it?";
                ans1 = "Paeroa";
                ans2 = "Pukekohe";
                ans3 = "Paengaroa";
                ans4 = "Porirua";
                break;
        }
    }

    /**
     * these return the anser and question to the main class to be used
     * @return
     */
    public String getAnswer() { return ans1; }
    public String questionString() { return ques; }
}
