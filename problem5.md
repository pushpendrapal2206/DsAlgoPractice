**Award Top K Hotels**

At Booking.com we want to recognize k performing hotels. We plan to identify these by analyzing their user reviews and calculating a review score for each of the hotel.
To calculate the score, we have:
a list of user reviews for each hotel, 
a list of positive keywords and 
a list of negative keywords. 
Positive keywords weigh 3 points each and negative keywords weigh -1 each.
  
For example, given the input below:
positive keywords: "breakfast beach citycenter location metro view staff price",
negative keywords: "not",
number of hotels: m = 5,
array of hotel ids: [1,2,1,1,2],
number of reviews: n=5,
array of reviews: [
"This hotel has a nice view of the citycenter. The location is perfect.",  
"The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
"Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
"They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
"Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."
],
number of hotels we want to award: k = 2,
then top k Hotels will be 2, 1.
  
Function Description
Complete the function awardTopKHotels in the editor below.
The function must return list of hotel ids sorted in descending order of their total score.
  
awardTopKHotels has the following parameter(s):
      positiveKeywords:   a space separated string of positive keywords in review
      negativeKeywords :   a space separated string of negative keywords in review
      hotelIds[hotelIds[0]...hotelIds[m-1]] :   an array of integers, which represents hotel IDs
      reviews[reviews[0]...reviews[n-1]] :   an array of String, which represents reviews.
reviews[i] is review for hotelIds[i]. reviews and hotelIds are one-to-one mapped.
      k :  the number of hotels we want to award.
  
Constraints
* m is always equal to n.
* If two hotels have the same score, they should be sorted in the output based on their ID, smallest ID first.
* The keywords to find will always be single words like "breakfast"  or "noise". Never double words like "swimming pool".
* Matching should be case-insensitive.
* Dots and commas should be ignored.
* If a word appears in a review twice, it should count twice.
* 1 ≤  m  ≤ 109
* 1 ≤  n  ≤ 109
* 1 ≤  hotelIds[i]  ≤ 105
* 1 ≤  k  ≤ 109
* In case one or more test cases time out, consider revisiting the runtime complexity of your algorithms.
* If k is greater than unique number of hotel ids, then list all the hotel ids
  
Input Format For Custom Testing

Sample Case 0

Sample Input For Custom Testing

* breakfast beach citycenter location metro view staff price
* not
* 5 1 2 1 1 2 5
* This hotel has a nice view of the citycenter. The location is perfect.
* The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
* Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
* They said I couldn't take my dog and there were other guests with dogs! That is not fair.
* Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.
* 2
  
Sample Output

* 2 1

**Explanation**

Hotel 2 has a score of 21. Score is calculated as follows,
* "location" and "citycenter" are mentioned twice each (score = 2 * 3 + 2 * 3 = 12), while
* "breakfast", "price", and "staff" are mentioned once each (score = 12 + (1 * 3 + 1 * 3 + 1 * 3) = 21).  
  
Hotel 1 on the other hand has a score of 17. Score is calculated as follows,
* "location" and "citycenter" also twice each (score = 2 * 3 + 2 * 3 = 12)  
* "view" and "metro" once each (score = 12 + (1 * 3 + 1 * 3) = 18) and
* “not” is once as well (score = 18 + (-1 * 1) = 17).