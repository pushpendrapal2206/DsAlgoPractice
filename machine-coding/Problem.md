1. **Identifying the trend of samsung mobiles in social media**

        We have incoming comments from all the social media that as samsung tagged in them. We need to identify the  positivity of the company in each hour in each platform
        You are also given a list of positive words and negative words
            Positive comment: A comment is said to be  positive if number of positive words are more than negative words
            Negative comment: A comment is said to be  negative if number of positive words are less than negative words
            Neutral comment: If number of positive words are same as negative words
        Positivity in an hour for a particular platform: If number of positive comments are more than negative comments from that platform in a particular hour
        Expected Output: Return positivity in for each platform in each hour as shown in the below example:
        Example list of positive and negative words
            Positive : [good, cheap]
            Negative : [costly, bad]
        Example Input of events:

            [
              {
                "platform": "facebook",
            "payload": {
                  “comment": “good touch screen @samsung",
                  },
                "hour": "4"
              },
              {
                "platform": "instagram",
            "payload": {
                  “post_info”: {
                    "post_text": "@samsung new phone is costly"
                  }
                },
                "hour": "5"
              },
              {
                "platform": "twitter",
             "payload": {
                  "tweet":”@samsung new phone has good battery but it is slow"
                },
                "hour": "5"
              },
              {
                "platform": "twitter",
             "payload": {
                  "tweet":”@samsung new phone has good battery and it looks stylish"
                },
                "hour": "5"
              }
            ]

        result:
            {
              “4”: {"facebook": "positive",  },
              “5”: {"instagram": "negative", "twitter": "positive"}
            }

2. **Online War Game Matchmaking engine.**
   
        Problem Definition :
        A company has come up with a new online war game, where players can play different game modes like TwoVTwo, FastDraw, Raid, etc. In order to keep it interesting, the company has introduced several locations where the game can be played like CastleTown, AirBase, SavageLand, etc. 
        Each game can be played in only one location at a time by a fixed number of players. 
        There is no limit on the number of games being run at a time or at any location but a player can play only one game at a time. Players can also form a team and send requests together for a match. 
        Each player has a rank based on his past performances in the game.
   
        You are tasked with creating a matchmaking engine for assigning a game to online players based on their request. 
        Players can send join request with filter criteria like :
            a) gameModes
            b) gameLocations
            c) level match criteria like same rank, any rank, etc
        Matchmaking engine should accept the request and then try to assign a game to the player in some location. 
        If no running instance of match exists with the criteria, then it creates one and then allocates it. 
        It can only create one game at a time. It starts the game only when all the required number of players have joined.
   
        Expectations :
            ● Players who have used SameRank as join criteria should match with players having the same rank only like gold with gold, platinum with platinum, etc.
            ● Players who have used AnyRank can join with players who have used AnyRank as join criteria or with players who are on the same rank as them.
            ● GameMatchRequests being sent concurrently should be demonstrated through a driver or test case.
            ● All operations need to be done in memory. You can use any supporting libraries if you need to perform non-core tasks for this problem.
            ● The Company may want to add new gameModes, gameLocations, levelMatchCriteria. So, keep this extensible.
            ● Code should be modular. Code should have basic OO design. Please do not jam in responsibilities of one class into another.
            ● Code should handle edge cases properly and fail gracefully.
   
        Guidelines :
            Make sure that you have working and demonstrable code.
            Make sure that code is functionally correct.
            Use of proper abstraction, modelling, separation of concerns is required.
            Code should be modular, readable and unit-testable.
            Code should easily accommodate new requirements with minimal changes.
            Proper exception handling is required.
   
        Sample GameData :
            GameModes = TwoVTwo (4 players), FastDraw (2 players), Raid (6 players)
            GameLocations = CastleTown, AirBase, SavageLand
            Ranks = Bronze, Silver, Gold, Platinum, Diamond
            Players = player1 (Bronze), player2 (Bronze), player3 (Bronze), player4 (Bronze), player5 (Silver), player6 (Gold), player7 (Gold), player8 (Platinum), player9 (Diamond)
   
        Example :
            a. Players = [player8, player9], GameModes = [FastDraw], Locations = [ CastleTown], Rank = AnyRank
            b. Players = [player1, player2], GameModes = [TwoVTwo], Locations = [ CastleTown, AirBase ], Rank = SameRank
            c. Players = [player3], GameModes = [TwoVTwo, Raid], Locations = [ SavageLand, AirBase ], Rank = SameRank
            d. Players = [player4], GameModes = [TwoVTwo, Raid], Locations = [ SavageLand, AirBase ], Rank = AnyRank
            e. Players = [player5, player6, player7], GameModes = [TwoVTwo, Raid], Locations = [ SavageLand ], Rank = AnyRank
   
        Case 1: Request a
        Output : Playing FastDraw game with players : player8, player9 in CastleTown
   
        Case 2 : Concurrent request b, c, d
        Output : Playing TwoVTwo game with players : player1, player2, player3, player4 in AirBase
   
        Case 3: Concurrent request c, d
        Output : Waiting Game with players : player3, player4
        Case 4 : Concurrent request a, e
        Output :
            Waiting Game with players : player3, player4
            Waiting Game with players : player5, player6, player7
            Playing FastDraw game with players : player8, player9 in CastleTown
        Case 5 : Request b
        Output :
            Waiting Game with players : player5, player6, player7
            Playing FastDraw game with players : player8, player9 in CastleTown
            Playing TwoVTwo game with players : player1, player2, player3, player4 in AirBase
