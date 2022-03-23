**Behavioral interview**


1. What is the most interesting project you have done so far ?
    * ODL service : 
        * used & learnt Apache camel, 
        * worked on AWS migration & learnt a lot about AWS during migration, 
        * solved one very complex issue. which was due to the limited number of file descriptors configured for the new version of docker on EC2 VMs.
    * CDS : 
        * Project was about showing hotel deals, for a recommended destination from a given source city corresponding to various city segments.
        * learned about apache flink, 
        * designed the system within the hotwire ecosystem. 
        * response time of the service was really fast ~50 ms. 
2. What has been the most challenging situation in your career so far ?
    * Managing an under performer which was hired by me.

            1. It was when I started acting as a tech lead in Expedia.
            2. I was given responsibilities to technically lead the team and own the end to end delivery of the features/product.
            3. hiring new resources and getting them onboarded was also part of my responsibilities.
            4. So, after I moved into this tech lead role, I hired a new resource. who performed well during the interviews.
            5. but, after 1 month or so, i felt he was delivering as per the expectations and as per his experience level.
            6. I had multiple 1:1 to understand the issue from his perspective. to understand if there was any support related issue from other team members or if there was any information that was not being shared with him.
            7. He said that I am getting the information and I have all the support from others.
            8. but he was not able to deliver. so, we remained in this phase for a quarter or so due to which one the project got delayed. it was escalated by senior leadership.
            9. Although it was a tough call, we had to let him go after monitoring him closely for 3-4 months.
        * Why it happened : 
            * This was my first time acting as a tech lead, so I did not want to throw him directly under the bus w/o giving him sufficient/ample time.
        * learning : 
            * I learned it the hard way but it is always good to call these things early to senior leadership so that action can be taken and it doesn't impact project deadlines.
    * Leading a full stack team given that I did not have much knowledge about Mobile/FE development.
            
            1. So, I was given this opportunity last year to lead a full stack team. 
            2. I took up this opportunity. We owned a new team which was being run from San jose.
            3. We started running it from Bangalore, we had this transition during mid FEB 2021 
            4. And we needed to meet the timelines for the DW2.0 project for Q1 which was targeted for the end of March 2021.
            5. After transition we figured out that there was a lot of work pending on the mobile development side & some work on the BE side along with api contract approval.
            6. It was a challenge to understand the actual estimates of the remaining work because I was not very familiar with mobile development.
            7. So, I learned it in a structured manner. I learnt about figma designs and then had multiple meetings with mobile developers in time to understand the time each screen would take to develop/test and to understand the rationale behind those estimates.
            8. Then, I connected with another engineering manager/lead who was leading a mobile development team in PayPal for the last 2-3 years to understand how we estimate, what all things/gotchas we need to keep in mind. What are different kinds of dependencies we have within PayPal like localization team, analytics team (for FPTI events and analytics), UX team for any design related changes, PayPal UI kit team for any UI component related dependencies & Mobile release engineering team for release process related dependencies.
            9. At the end we were able to deliver the project within the timelines although It was a great learning experience for me on the mobile development side to understand the development cycle and various mobile specific dependencies and all.
            10. I had to persuade the contractors to get it done within the timelines, we had to work on some weekends too. I was sitting with my developers day and night on weekends to help them in any manner I can.
3. Tell me about a time when you were asked to do something you had never done before. How did you react? What did you learn?
    * Leading a full stack team given that I did not have much knowledge about Mobile/FE development.
        * I took it up as a challenge. I learnt about the mobile development ecosystem within PayPal.
        * I talked to folks (leads/EMs) from other teams to understand the release process, estimation techniques etc.
        * Learnt about different kinds of dependencies we have within PayPal like localization team, analytics team (for FPTI events and analytics), UX team for any design related changes, PayPal UI kit team for any UI component related dependencies & Mobile release.
4. Tell me about a time when you had to adjust to a colleague’s working style in order to complete a project or achieve your objectives.
    * This was recently when I was leading the Loyalty platform team.
        * We have a colleague who is not good at communicating (using the English language).
        * And because we took over this project from a team which was San Jose based. So, initial one week we had KT and all.
        * This colleague  was not able to understand much during the KTs due to communication problems & he was not able to ask his question.
        * So, I acted on his behalf. I used to go to every meeting with him and have some sort of translation done for him and ask questions  on his behalf.
        * Also, during debugging any issues where we need to interact with multiple teams. I used to understand the issue by talking to different teams and then translate the issue and solution to him.
        * I had to do it because we had strict delivery timelines for the project and because we just owned this team. So, on the functional front, the team was not aware about every corner use case. 
5. Describe the best partner or supervisor with whom you’ve worked. What part of their managing style appealed to you?
    * This was when I was part of the Loyalty team, acting as a lead.
        * I really liked my manager because he was so good at identifying the potential of the team mates and assigning the roles to them as per their capability.
        * I like that he used to believe in freedom and independence. Even when he assigned me a tech lead role. Even though i told him that I don’t have expertise in Mobile development.
        * He said that, I have confidence in you that you can play this role effortlessly.
        * So, he used to identify the person’s capability very quickly and then have a growth path for the person even if that person doesn’t believe in his capabilities.
6. Give me an example of a time when you felt you led by example. What did you do and how did others react?
    * It was when I was acting as a tech lead for the Loyalty Platform team.
        * We needed to present the overall architecture of our system to senior leadership. And it included both the backend as well as the mobile side of the architecture.
        * Backend architecture part was totally okay because I did HLD & LLD of the system and I had a fair bit of an idea about various components &  dependencies in BE architecture.
        * But on Mobile because we had the resources as contractors who are not that competitive when it comes to the bigger picture of the system.
        * So, I can’t rely on them for FE architecture. 
        * So, I went ahead to understand the overall Mobile development architecture, different components being used, different common libraries being used and I even dug up the code to understand a few things.
        * And finally I was able to come up with a very good High level diagram of overall Mobile architecture. 
        * Then, I reviewed it with my Mobile developers & they were surprised, I even was able to find out things which were hidden in code actually.
        * From that day onwards they had more confidence. And they thought if a guy with a BE development background can do this thing. We should be able to do it more easily. 
        * And my manager was also very impressed with the way I presented this FE architecture and talked about various components and answered the question from senior leadership.
7. Tell me about the toughest decision you had to make in the last six months.
    * Letting anyone go in your team is always a tough decision. 
        * So, we hired one Android developer and we had strict delivery timelines to deliver this DW2.0  project which included major changes on the UI/UX side.
        * We gave time to that developer to get ramped up and have a KT session from a fellow developer & to understand the overall ecosystem, various components and dependencies.
        * After a sprint we started assigning stories to him. Although we started with small stories, he was able to perform & deliver.
        * He dragged one simple story for more than 2 sprints.
        * I didn’t want to immediately put him under the bus and let him go because he joined just 3-4 weeks ago.
        * So, I had 1:1 with him to understand any concerns from his point of view. But, he did not say anything which can be considered as a concern like lack of knowledge sharing by fellow team mates etc.
        * So after around 6 weeks, I talked to my Manager and told him the whole situation. He asked me what do you want to do ?
        * I told him that He is not delivering at all and he is stuck on one story since he has joined.
        * So, I told him that it will be good if we release and put into a pool of candidates which can be used by other teams.
        * So, yeah we literally have to let him go. 
        * It was a very tough situation for me to decide because I was facing this the first time as a tech lead where on the basis of my decision somebody was being fired.
