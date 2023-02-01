package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ChromeTest implements ActionListener {
    private JFrame frame;
    private JButton searchButton;
    private WebDriver driver;
    private static Logger LOGGER = Logger.getLogger("ChromeTest");

    public ChromeTest() {
        frame = new JFrame("Chrome Test");
        searchButton = new JButton("Search");

        searchButton.addActionListener(this);

        frame.setMinimumSize(new Dimension(250,250));
        frame.setLocationRelativeTo(null);

        frame.add(searchButton);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ChromeTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.google.it");
        LOGGER.info("Started session of chrome driver");

        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        waitSpecificSeconds(5);

        WebElement searchBox = driver.findElement(By.name("q"));
        LOGGER.info("Text input found");

        searchBox.sendKeys(frame.getTitle());
        LOGGER.info("Text input written");

        searchBox.submit();
        LOGGER.info("Text input sent");

        waitSpecificSeconds(5);

        driver.quit();
        System.exit(0);
    }

    public void waitSpecificSeconds(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}