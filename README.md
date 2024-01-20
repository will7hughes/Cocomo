# Cocomo
Input variables include team size and lines of code. Calculations can be performed at basic or intermediate levels. For basic calculations, the output includes staff size, effort, and development time. Additionally, the model provides different effort values for maximum, mean, and mode.

The mode is determined as part of the analysis, and it's noteworthy that increasing team size will alter the mode, contingent upon the specific team size. Changes in lines of code impact the required effort, staff size, and development time.

## Applications for Cocomo
A model like this could be immensely useful in real-world software project management and planning scenarios. Here are some potential applications:

Resource Planning: By inputting team size and lines of code, project managers can gain insights into the optimal staff size required for a project. This helps in efficient resource allocation, ensuring that the team is neither understaffed nor overstaffed.

Effort Estimation: The model's ability to calculate different effort values, including maximum, mean, and mode, provides a range of estimates. This can aid in more accurate effort estimation for a project, helping teams set realistic timelines and allocate resources effectively.

Development Time Prediction: With the output including development time, the model assists in predicting the time required for project completion. This is crucial for project scheduling, allowing teams to manage deadlines and expectations more effectively.

Sensitivity Analysis: The model's recognition that increasing team size alters the mode introduces a level of sensitivity analysis. Teams can explore how changes in team size might impact the project dynamics, providing valuable insights into scalability and team structure optimization.

Optimization Strategies: Understanding how changes in lines of code affect effort, staff size, and development time enables teams to optimize their coding practices. This insight can guide decisions on code complexity, modularization, and overall project architecture.

Risk Mitigation: By having a model that considers multiple factors and provides a range of outcomes, project managers can better anticipate and mitigate risks. This contributes to more informed decision-making throughout the software development life cycle.

Scenario Planning: The ability to perform calculations at basic or intermediate levels allows for scenario planning. Teams can explore different project configurations, making informed decisions based on the desired level of complexity or resources available.

In essence, this model offers a versatile toolkit for project managers and software development teams, providing actionable insights for better planning, resource management, and decision-making in the dynamic environment of software development.

# Installing Android Studio
- Download Android Studio here https://developer.android.com/studio
  - Leave everything checked and just do a normal install
  - Personalize it how you would like then click finish
  
 # Creating a Project from Scratch
- Choose empty activity
- Name your project
- Choose Kotlin or Java
  - Kotlin can also use java code, so I recommend Kotlin
- Click finish

# Importing a Project from Git
- Click the VCS tab in Android Studio
- Click checkout from version control
- Click git
- Paste the github link into the URL
  - The link for this project is https://github.com/CodyStandridge/AndroidMidTerm.git
- Click clone
- Click yes to open the project
- Leave the setting as is (use explicit module groups and use default gradle wrapper)
- Finally click ok

# Creating a Virtual Device for Testing
- Click AVD Manager (5th button from the right)
- Click create virtual device
- Choose any device (I chose Pixel 2)
- Chose Android Pie or Oreo
- Click next then finish

# Starting
- Main file is MainActivity.kt
  - This is where you will write your code for the most part
- activity_main.xml is where you will make any graphical changes
  - Here you will add buttons, text boxes, layouts, etc. 

# Android Mid Term
- For this project you will need to display the random number gotten from your websites 
- One method for this is to use Volley to make GET requests. 
  - You can find out how to use it here https://developer.android.com/training/volley/request
  - This repository also has example code using Volley to connect to the OU calendar
- In order to make GET request to your website you will need to make endpoints
  - You can find out how to make endpoints for an app engine here: https://cloud.google.com/endpoints/docs/openapi/get-started-app-engine-standard
  - You can find out how to make endpoints for a compute engine here: https://cloud.google.com/endpoints/docs/openapi/get-started-compute-engine-docker
