package com.example.l2task3.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import com.example.l2task3.utils.UploadUtil;
import org.openqa.selenium.By;

import java.util.*;
import java.util.List;

public class AvatarAndInterestsForm extends Form {

    private final By interestsListItem = By.xpath("//div[@class='avatar-and-interests__interests-list__item']");
    private final By checkBox = By.xpath("//span[@class='checkbox__box']");
    private final List<IElement> interestsList = getElementFactory().findElements(interestsListItem, ElementType.COMBOBOX);
    private final IButton uploadBtn = getElementFactory()
            .getButton(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "upload");
    private final IButton nextBtn = getElementFactory()
            .getButton(By.xpath("//button[contains(text(), 'Next')]"), "next");
    private final ILabel label = getElementFactory()
            .getLabel(By.xpath("//div[@class='avatar-and-interests__avatar-image']"), "image");

    public AvatarAndInterestsForm() {
        super(By.xpath("//div[@class='avatar-and-interests__form']"), "Avatar and interests form");
    }

    public void clickRandomInterests(String numberOfInterests) {
        int num = Integer.parseInt(numberOfInterests);
        clickUnselectAll();
        Random random = new Random();
        List<String> noClickList = new ArrayList<>(List.of("Select all", "Unselect all"));

        for (int i = 0; i < num; i++) {
            int randomInt = random.nextInt(interestsList.size());
            IElement iElement = interestsList.get(randomInt);
            String name = iElement.getText();
            if (!noClickList.contains(name)) {
                selectCheckBoxByName(name);
                noClickList.add(name);
            } else {
                i--;
            }
        }
    }

    public void clickUploadBtn() {
        uploadBtn.clickAndWait();
    }

    public void uploadImg(String path) {
        UploadUtil.uploadFile(path);
        AqualityServices.getConditionalWait().waitFor(() -> label.state().waitForExist());
    }

    public void clickNextBtn() {
        nextBtn.clickAndWait();
    }

    private void selectCheckBoxByName(String name) {
        IElement checkBox = interestsList.stream()
                .filter(iElement -> iElement.getText().equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .findChildElement(this.checkBox, ElementType.CHECKBOX);

        checkBox.clickAndWait();
    }

    private void clickUnselectAll() {
        selectCheckBoxByName("Unselect all");
    }
}
