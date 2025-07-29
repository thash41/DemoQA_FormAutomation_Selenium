
# 🧪 DemoQA Form Automation Project

This project automates the **"Practice Form"** on [DemoQA](https://demoqa.com/automation-practice-form) using **Selenium WebDriver**, **TestNG**, and **Java**. It’s designed as a hands-on learning experience for beginners in test automation and CI/CD using Jenkins.


---

## 🚀 Features

✅ Automates complete form submission  
📅 Handles date picker (DOB)  
📁 Uploads image file  
🔤 Handles auto-suggestion input fields  
📍 Selects state & city (dynamic dropdowns)  
🧾 Validates confirmation modal  
🧪 Structured with TestNG framework  
🔧 Maven-managed dependencies  
⚙️ Integrated with Jenkins CI/CD pipeline  
📊 Generates TestNG & HTML test reports

---

## 🧰 Technologies Used

| Tool           | Purpose                             | Version          |
|----------------|-------------------------------------|------------------|
| **Java**       | Programming language                | 21.0.6           |
| **Selenium**   | Web automation tool                 | 4.21.0           |
| **TestNG**     | Testing framework                   | 7.10.1           |
| **Maven**      | Build & dependency management       | 3.9.10           |
| **Chrome**     | Browser for test execution          | 137.0.7151.122   |
| **Eclipse IDE**| Code editor / development           | 2024-03          |
| **Jenkins**    | CI/CD – Run tests on code changes   | 2.452+ (LTS)     |
| **GitHub**     | Version control / code hosting      | —                |

---

## 📁 Project Structure

```
DemoQA_FormAutomation_Project/
├── pom.xml
├── testng.xml
├── .gitignore
├── screenshots/
│   ├── Screenshot 1.png
│   └── Screenshot 2.png
└── src/
    ├── main/java/com/dezlearn/qa/DemoQA_FormAutomation_Project/
    │   └── App.java
    └── test/java/com/dezlearn/qa/DemoQA_FormAutomation_Project/
        ├── AppTest.java
        └── PracticeFormTest.java
```

---

## ▶️ How to Run the Test Locally

### 1️⃣ Clone the Repository:
```bash
git clone https://github.com/thash41/DemoQA_FormAutomation_Selenium.git
```

### 2️⃣ Import into Eclipse:
- Go to **File → Import → Maven → Existing Maven Projects**
- Select the cloned folder.

### 3️⃣ Run the Test:
- Open `PracticeFormTest.java`
- Right-click → Run As → **TestNG Test**

---

## ⚙️ Jenkins CI/CD Integration

This project is fully integrated with **Jenkins** to run tests automatically when changes are pushed to GitHub.

### 🛠 Jenkins Setup Steps

1. **Install Jenkins**  
   Download from [https://jenkins.io](https://jenkins.io)  
   Start with:  
   ```bash
   java -jar jenkins.war --httpPort=8080
   ```

2. **Install Required Plugins**
   - Maven Integration Plugin
   - Git Plugin
   - TestNG Results Plugin

3. **Configure Tools**
   - `Manage Jenkins → Global Tool Configuration`
   - Add JDK and Maven paths

4. **Create Freestyle Project**
   - Source Code Management → Git → Add your GitHub repo
   - Build Triggers → Poll SCM → `H/5 * * * *`
   - Build → `clean test`
   - Post-build Actions:
     - **Publish TestNG results:** `test-output/testng-results.xml`
     - **Archive Artifacts:** `target/surefire-reports/*.html`

5. **Run Job**
   - Manually or automatically when you push to GitHub

---

## 📸 Sample Screenshots

Screenshots of successful test execution can be found in the `/screenshots` folder.

---

## 🙋 Author

**Jayani Thashmila**  
📧 Email: jayanithashmila@gmail.com  
🌐 GitHub: [@thash41](https://github.com/thash41)

---

## 📌 License

This project is for **educational/demo purposes** only. 

