# CommonWealthAndroid
Android version of CommonWealth app for HackDavis 2021

# About
Commonwealth is the kickstarter for community service. It's an android app where users can post community service projects they want to lead, and where the community can browse projects to volunteer their time towards helping the world.

# Contributors
Harpreet Padda, Foad Olfat, and Mira Tellegen

# Submission Categories
Best Hack for Social Good 
Best Hack for Inclusion 
Best Health Hack
Best Use of Google Cloud

# Inspiration
As third-year college students, everyone on our team has lost time connected to other students on campus and in the community. We've become more isolated than ever, and over the last 11 months sheltering in place, we've grown more and more anxious about the state of the world. When outside feels dangerous, it can be harder than ever to feel like you can make a difference, and we've seen hopelessness in our communities grow with covid surges, political unrest, and the impeachment and widespread violence highlighted in the news cycle. We envisioned our app as a new platform to connect people towards social change. Inspired by the crowdsourcing of kickstarter, we wanted to create a space for people to reach out to their community to make a difference, with all types of community service.

# What our hack does
Our hack is an android app using java and Google Firebase. When users open up the app, they can create a call-to-action for a community service task they want to recruit helpers for, including information like the time and how many people needed. Once they create their event, their event is stored in firebase to be visible to all users, so others can sign up to help. They can also browse all types of community service events on our home page, and sign up to help out in their community, or connect with others hoping to make a difference. To create these functionalities, we created clickable buttons and data tracking with Android Studio using java and Gradle Scripts, and tracked data in Firebase laid out the app in SceneBuilder. One big issue we faced was how to record and filter available community service events, whether it was with local documents or a cloud-based database. 

# How we built it
Android Studio
Java
Google Firebase
Gradle Scripts
MongoDB
JavaFX 
IntelliJ IDEA 
SceneBuilder 
CSS 
Canva 
ProCreate 
Github

# Difficulties
We faced major difficulties with event storing in this project. We initially constructed our user input and event storage using java objects and hashmaps translated to text files. We built a functional javafx app using SceneBuilder to construct the GUI. Unfortunately, Google Firebase's prerequisites meant we weren't able to cloud store the community service events tracked in our app. Although our app is currently running locally on our devices, we wanted all events added to be visible from any device, and we hope to eventually host in the cloud. We got full mongoDB functionality to use their cloud database system with a mongoDB atlas cluster, and thought we could make the GUI app work using that service. However, we found that storing and retrieving data from mongoDB was rarely done in java methods, so although we could connect out cluster to intelliJ, we couldn't store the events in our methods. Since a main goal of our app is accessibility to large communities, we really wanted to use Google Firebase. So, we reconstructed our interface in Android Studio so we could link Firebase to our android app. With this shift, we were able to make cloud storage of our community service events scaleable. This also gave us the option to filter events to display ojn the homepage for browsing based on criteria. We also struggles a lot with the Gradle Scripts interactions with git, because when the project is cloned, the Gradle Scripts and run configurations don't come synced. We had to persevere in syncing our runs consistently across devices, and had to clean the program often to prevent durplicate build scripts from being created. One other large struggle was the timing, because by switching our format of the app halfway through the ahckathon time, we lost the opportunity to add some functionalities we wanted, such as searching local events in the Google Maps API and implementing a sign-in system.
What we learned
What's next for CommonWealth
