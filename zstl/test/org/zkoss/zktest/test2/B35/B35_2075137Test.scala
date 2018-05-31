/* B35_2075137Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 11, 2011 08:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2075137.zul,B,E,Window,Button")
class B35_2075137Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <zk xmlns="http://www.zkoss.org/2005/zul" xmlns:h="http://www.w3.org/1999/xhtml" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.zkoss.org/2005/zul/zul.xsd">
        <groupbox>
          <vbox>
            <label value="1.Adjust all slider to see if label value is updated correctly."/>
            <label value="2.Make sure slider button color doesn't lock if mouse is dragged away from it."/>
          </vbox>
        </groupbox>
        <window title="Vertical Sliders in Containers" border="normal" width="400px">
          <hbox>
            Slider in a hbox
            <slider id="slider" orient="vertical" curpos="4" maxpos="5">
              <attribute name="onScroll">
                textLabel.setValue("The Scrolled value is..... "+slider.getCurpos()+"");
              </attribute>
            </slider>
            <label id="textLabel" value="TESTING SLIDERS FUNCTIONALITY..."/>
          </hbox>
          <vbox>
            Slider in a vbox
            <slider id="slider2" orient="vertical" curpos="4" maxpos="5">
              <attribute name="onScroll">
                textLabel2.setValue("The Scrolled value is..... "+slider2.getCurpos()+"");
              </attribute>
            </slider>
            <label id="textLabel2" value="TESTING SLIDERS FUNCTIONALITY..."/>
          </vbox>
        </window>
        <window title="Horizontal Sliders in Containers" border="normal" width="400px">
          <hbox>
            Slider in a hbox
            <slider id="slider" orient="horizontal" curpos="4" maxpos="5">
              <attribute name="onScroll">
                textLabel3.setValue("The Scrolled value is..... "+slider.getCurpos()+"");
              </attribute>
            </slider>
            <label id="textLabel3" value="TESTING SLIDERS FUNCTIONALITY..."/>
          </hbox>
          <vbox>
            Slider in a vbox
            <slider id="slider2" orient="horizontal" curpos="4" maxpos="5">
              <attribute name="onScroll">
                textLabel4.setValue("The Scrolled value is..... "+slider2.getCurpos()+"");
              </attribute>
            </slider>
            <label id="textLabel4" value="TESTING SLIDERS FUNCTIONALITY..."/>
          </vbox>
        </window>
      </zk>
    """;
    runZTL(zscript, () => {
      // Click on first slider
      click(jq("$slider").get(0));
      waitResponse(true);

      // Move the mouse over the first slider
      //Scripts.triggerMouseEventAt(getWebDriver(), jq("$slider").get(0), "mousemove", "0,4")
      val btn = engine.$f("slider").$n("btn")
      dragdropTo(btn, "5,5", "5,50")
      waitResponse(true);
      // check button color
      verifyFalse("#d6f0fd".equals(jq(btn).css("backgroind-color")));

      verifyFalse("The value should be ...", jq("$textLabel:contains(TESTING SLIDERS FUNCTIONALITY...)").exists());

      // Click on second slider
      click(jq("$slider2").get(0));
      waitResponse(true);

      // Move the mouse over the second slider
      // The event doesn't take the last argument, so always moves the same distance
      // Scripts.triggerMouseEventAt(getWebDriver(), jq("$slider2").get(0), "mousemove", "")
      //waitResponse(true);

      verifyFalse("The value should be ...", jq("$textLabel2:contains(TESTING SLIDERS FUNCTIONALITY...)").exists());

      // Click on third slider
      click(jq("$slider").get(1));
      waitResponse(true);

      // Move the mouse over the third slider
      // The event doesn't take the last argument, so always moves the same distance
      val btn2 = jq("$slider:eq(1)").toWidget().$n("btn");
      dragdropTo(btn2, "5,5", "5,50")
      waitResponse(true);

      // check button color
      verifyFalse("#d6f0fd".equals(jq(btn).css("backgroind-color")));

      verifyFalse("The value should be ...", jq("$textLabel3:contains(TESTING SLIDERS FUNCTIONALITY...)").exists());

      // Click on fourth slider
      click(jq("$slider2").get(1));
      waitResponse(true);

      verifyFalse("The value should be ...", jq("$textLabel4:contains(TESTING SLIDERS FUNCTIONALITY...)").exists());

    })
  }
}