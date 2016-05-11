package org.zkoss.zktest.test2.F80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F80-ZK-3041.zul")
class F80_ZK_3041Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        //1st
        var chosenBox = jq(".z-chosenbox").eq(0)
        var input = jq(".z-chosenbox-input").eq(0)
        // click to focus on chosenbox
        click(input)
        waitResponse(true)

        verifyEquals(4, jq(".z-chosenbox-option:visible").length)

        // sendKeys "a"
        sendKeys(input, "a")
        waitResponse(true)
        // check that there are two options
        verifyEquals(2, jq(".z-chosenbox-option:visible").length)

        // then select first
        click(jq(".z-chosenbox-option:visible").eq(0))
        waitResponse(true)
        // check that a is selected
        verifyEquals("a", chosenBox.find(".z-chosenbox-item-content").text)

        // click to focus on chosenbox
        click(input)
        waitResponse(true)

        verifyEquals(4, jq(".z-chosenbox-option:visible").length)

        // sendKeys "a"
        sendKeys(input, "a")
        waitResponse(true)

        // check that there is only one option
        verifyEquals(1, jq(".z-chosenbox-option:visible").length)

        // then select first
        click(jq(".z-chosenbox-option:visible").eq(0))
        waitResponse(true)
        // check selection
        verifyEquals("a", chosenBox.find(".z-chosenbox-item-content").eq(0).text)
        verifyEquals("Adam adam@company.org", chosenBox.find(".z-chosenbox-item-content").eq(1).text)

        //2nd
        chosenBox = jq(".z-chosenbox").eq(1)
        input = jq(".z-chosenbox-input").eq(1)
        // click to focus on chosenbox
        click(input)
        waitResponse(true)

        verifyEquals(4, jq(".z-chosenbox-option:visible").length)

        // sendKeys "a"
        sendKeys(input, "a")
        waitResponse(true)
        verifyEquals(1, jq(".z-chosenbox-option:visible").length)

        // then select first
        click(jq(".z-chosenbox-option:visible").eq(0))
        waitResponse(true)
        // check that a is selected
        verifyEquals("Adam adam@company.org", chosenBox.find(".z-chosenbox-item-content").text)

        //3rd
        chosenBox = jq(".z-chosenbox").eq(2)
        input = jq(".z-chosenbox-input").eq(2)
        // click to focus on chosenbox
        click(input)
        waitResponse(true)

        verifyEquals(0, jq(".z-chosenbox-option:visible").length)

        // sendKeys "t"
        sendKeys(input, "t")
        waitResponse(true)
        verifyEquals(5, jq(".z-chosenbox-option:visible").length)

        // then select first
        click(jq(".z-chosenbox-option:visible").eq(0))
        waitResponse(true)
        verifyEquals("t", chosenBox.find(".z-chosenbox-item-content").text)

        // click to focus on chosenbox
        click(input)
        waitResponse(true)
        verifyEquals(0, jq(".z-chosenbox-option:visible").length)

        sendKeys(input, "t")
        waitResponse(true)

        verifyEquals(4, jq(".z-chosenbox-option:visible").length)

        // then select first
        click(jq(".z-chosenbox-option:visible").eq(0))
        waitResponse(true)
        // check selection
        verifyEquals("t", chosenBox.find(".z-chosenbox-item-content").eq(0).text)
        verifyEquals("tag 1", chosenBox.find(".z-chosenbox-item-content").eq(1).text)

        //4th
        chosenBox = jq(".z-chosenbox").eq(3)
        input = jq(".z-chosenbox-input").eq(3)
        // click to focus on chosenbox
        click(input)
        waitResponse(true)

        verifyEquals(0, jq(".z-chosenbox-option:visible").length)

        // sendKeys "t"
        sendKeys(input, "t")
        waitResponse(true)
        verifyEquals(4, jq(".z-chosenbox-option:visible").length)

        // then select first
        click(jq(".z-chosenbox-option:visible").eq(0))
        waitResponse(true)
        verifyEquals("tag 1", chosenBox.find(".z-chosenbox-item-content").text)
    })
  }
}

