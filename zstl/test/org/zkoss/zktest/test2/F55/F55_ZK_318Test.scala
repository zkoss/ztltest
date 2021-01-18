/* F55_ZK_318Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 22 10:40:02 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F55

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}
import org.zkoss.ztl.unit.{ClientWidget, Widget}

/**
  * A test class for bug ZK-318
  *
  * @author benbai
  *
  */
@Tags(tags = "F55-ZK-318.zul,F60,B,E,combobutton")
@IgnoreBrowsers("ios,android")
class F55_ZK_318Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var messageBox: Widget = engine.$f("messageBox");
        var messageBoxTwo: Widget = engine.$f("messageBoxTwo");
        var li: Widget = engine.$f("li");
        var lb: Widget = engine.$f("lb");
        var bd: Widget = engine.$f("bd");
        var bd2: Widget = engine.$f("bd2");
        var cbx: Widget = engine.$f("cbx");
        var ppOne: Widget = engine.$f("ppOne");
        var ppTwo: Widget = engine.$f("ppTwo");
        var pp2About = ".z-menu:contains(About)";
        var pp2Menu = ".z-menu:contains(Menu)";
        var pp2ColorPicker = ".z-menu:contains(Color)";
        var mbHelp: Widget = engine.$f("mbHelp");

        def clickAndWait(wgt: ClientWidget) {
          click(wgt);
          waitResponse();
        }

        def clickAndCheck(wgt: ClientWidget, cnt: Array[String], box: Array[Widget]) {
          clickAndWait(wgt);

          for (i <- 0 until cnt.length) {
            verifyContains("Should has this message: " + cnt(i),
              box(i).$n().attr("value"), cnt(i))
          }
        }

        def openMenu(wgts: Array[String]) {
          for (i <- 0 until wgts.length) {
            mouseOver(jq(wgts(i)).toWidget().$n("a"));
            waitResponse();
          }
        }

        // step 1
        clickAndCheck(jq(bd).toWidget().$n("real"),
          Array("combobutton one clicked"), Array(messageBox));
        // step 2
        clickAndCheck(jq(bd).toWidget().$n("btn"),
          Array("combobutton one opened", "popup opened"),
          Array(messageBox, messageBoxTwo));
        verifyTrue("combobutton one should opened",
          jq(ppOne.$n()).is(":visible"));

        // step 3
        clickAndCheck(jq(bd).toWidget().$n("btn"),
          Array("combobutton one closed"),
          Array(messageBox));
        verifyFalse("combobutton one should closed",
          jq(ppOne.$n()).is(":visible"));

        // step 4
        clickAndCheck(jq(bd2).toWidget().$n("real"),
          Array("combobutton two clicked"), Array(messageBox));
        clickAndCheck(jq(bd2).toWidget().$n("btn"),
          Array("combobutton two opened", "popup opened"),
          Array(messageBox, messageBoxTwo));
        verifyTrue("combobutton two should opened",
          jq(ppTwo.$n()).is(":visible"));

        clickAndCheck(jq(bd2).toWidget().$n("btn"),
          Array("combobutton two closed"),
          Array(messageBox));
        verifyFalse("combobutton two should closed",
          jq(ppTwo.$n()).is(":visible"));

        // step 5
        clickAndCheck(jq(bd2).toWidget().$n("btn"),
          Array("combobutton two opened"),
          Array(messageBox));

        // step 6
        openMenu(Array(pp2About, pp2Menu, pp2ColorPicker));
        verifyTrue("Color picker should opened",
          jq(".z-colorpalette-popup").is(":visible"));
        // step 7
        clickAndWait(mbHelp);
        openMenu(Array(".z-menu:contains(About1)"));
        clickAndWait(jq(".z-label:contains(message box)"));

        // step 8
        clickAndCheck(jq(bd2).toWidget().$n("btn"),
          Array("combobutton two opened"),
          Array(messageBox));
        openMenu(Array(pp2About, pp2Menu, pp2ColorPicker, pp2ColorPicker)); // don't know why we need two pp2ColorPicker but it works
        verifyTrue("Color picker should opened",
          jq(".z-colorpalette-popup").is(":visible"));

        // step 9
        clickAndCheck(jq(bd).toWidget().$n("btn"),
          Array("combobutton one opened"),
          Array(messageBox));
        verifyTrue("combobutton one should opened",
          jq(ppOne.$n()).is(":visible"));
        clickAndWait(li.firstChild());
        verifyFalse("combobutton one should opened",
          jq(ppOne.$n()).is(":visible"));

        // step 10
        clickAndWait(cbx.$n("real"))

        // step 11
        clickAndWait(jq(".z-button:contains(change image)"))

        // step 12
        messageBox.toElement().set("value", "")
        messageBoxTwo.toElement().set("value", "")
        click(jq("@button:contains(open combobutton one)"))
        verifyEquals("", getValue(messageBox))
        verifyEquals("", getValue(messageBoxTwo))
        clickAndWait(jq(".z-label:contains(message box)"))

        // step 13
        messageBox.toElement().set("value", "")
        messageBoxTwo.toElement().set("value", "")
        click(jq("@button:contains(open combobutton two)"))
        verifyEquals("", getValue(messageBox))
        verifyEquals("", getValue(messageBoxTwo))
        clickAndWait(jq(".z-label:contains(message box)"))

        // step 14
        clickAndWait(cbx.$n("real"))
        val bgColor = jq("@window .z-window-content").get(0).attr("style.backgroundColor")
        clickAndWait(jq(bd2).toWidget.$n("btn"))
        openMenu(Array(pp2About, pp2Menu, pp2ColorPicker, pp2ColorPicker))
        evalScript(jq(".z-colorpalette-color:eq(22)").get(0) + ".click()")
        waitResponse()
        verifyNotEquals("The background color didn't change", bgColor, jq("@window .z-window-content").get(0).attr("style.backgroundColor"))

        // step 15
        clickAndWait(jq("@button:contains(change child)"))
        clickAndWait(jq(bd).toWidget.$n("btn"))
        verifyTrue("combobutton two should opened", jq(ppTwo.$n()).is(":visible"))
        clickAndWait(jq(bd2).toWidget.$n("btn"))
        verifyTrue("combobutton one should opened", jq(ppOne.$n()).is(":visible"))
      }
    )
  }
}
