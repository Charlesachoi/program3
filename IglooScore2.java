
/***
* Olympic Igloo Scoring Class
*
* For the Winter Olympics igloo building event there are
* three judges, each of which gives a score from 0 to 50 
* (inclusive), but the lowest score is thrown out and the 
* competitor's overall score is just the sum of the two
* highest scores. This class supports the recording of the
* three judge's scores, and the computing of the competitor's
* overall score.
*
***/

public class IglooScore2
{

   int score1;
   int score2;
   int score3;

public IglooScore2()
{
   score1 = 0;
   score2 = 0;
   score3 = 0;
}

public void recordScores(int s1, int s2, int s3)
{
   score1 = s1;
   score2 = s2;
   score3 = s3;
}

public int overallScore()
{
   int s, s1, s2;
   if (score1 < score2 && score1 < score3) {
      s1 = score2;
      s2 = score3;
   } else if (score2 < score1 && score2 < score3) {
      s1 = score1; //This should store both highest numbers but was storing lower value. Should store score1 and score3.
      s2 = score3;
   } else if (score3 < score1 && score3 < score2) {
      s1 = score1; //should store both highest but was storing lower value
      s2 = score2;
   } else {
      s1 = score1; //99 value does not make sense make them equal to score1 or score2 or score3, any two of the three.
      s2 = score2;
   }
   s = s1 + s2;
   return s;
}

public static void main(String args[])
{
   int s1, s2, s3;
   if (args==null || args.length != 3) { //there is no case where it is both since null length does not exist
      System.err.println("Error: must supply three arguments!");
      return;
   }
   try {
      s1 = Integer.parseInt(args[0]);
      s2 = Integer.parseInt(args[1]);
      s3 = Integer.parseInt(args[2]);
   } catch (Exception e) {
      System.err.println("Error: arguments must be integers!");
      return;
   }
   if (s1<0 || s1>50 || s2<0 || s2>50 || s3<0 || s3>50) {
      System.err.println("Error: scores must be between 0 and 50!");
      return;
   }
   IglooScore2 score = new IglooScore2();
   score.recordScores(s1,s2,s3);
   System.out.println("Overall score: " + score.overallScore());
   return;
}

} // end class

