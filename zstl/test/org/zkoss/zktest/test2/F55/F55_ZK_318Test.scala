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

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-318
 * @author benbai
 *
 */
@Tags(tags = "F55-ZK-318.zul,F60,B,E,combobutton")
class F55_ZK_318Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
			<zk>

				<zscript>
					int count = 0;
				</zscript>
				<window id="win1" title="test win" border="normal">
					<vbox>
						<hbox>
							message box
							<textbox id="messageBox" width="300px" />
							message box two
							<textbox id="messageBoxTwo" width="300px" />
						</hbox>
						<hbox>
							<combobutton id="bd" label="test combobutton one" image="img/circle.png">
								<attribute name="onClick">
									messageBox.setValue(count++ + ". combobutton one clicked");
								</attribute>
								<attribute name="onOpen">
									messageBox.setValue(count++ + ". combobutton one " + (event.isOpen()? "opened" : "closed"));
								</attribute>
								<popup id="ppOne">
									<attribute name="onOpen">
										messageBoxTwo.setValue("popup " + (event.isOpen()? "opened" : "closed"));
									</attribute>
									<vbox>
										<hbox>
											Search
											<textbox />
										</hbox>
										<listbox id="lb" width="200px" onClick="self.getParent().getParent().getParent().setOpen(false);">
											<listhead>
												<listheader label="Name" />
												<listheader label="Description" />
											</listhead>
											<listitem id="li">
												<listcell label="John" />
												<listcell label="CEO" />
											</listitem>
											<listitem>
												<listcell label="Joe" />
												<listcell label="Engineer" />
											</listitem>
											<listitem>
												<listcell label="Mary" />
												<listcell label="Supervisor" />
											</listitem>
										</listbox>
									</vbox>
								</popup>
							</combobutton>
							<combobutton id="bd2" label="test combobutton two">
								<attribute name="onClick">
									messageBox.setValue(count++ + ". combobutton two clicked");
								</attribute>
								<attribute name="onOpen">
									messageBox.setValue(count++ + ". combobutton two " + (event.isOpen()? "opened" : "closed"));
								</attribute>
								<menupopup  id="ppTwo">
									<attribute name="onOpen">
										messageBoxTwo.setValue("menu popup " + (event.isOpen()? "opened" : "closed"));
									</attribute>
									<menuitem label="Index" onClick="alert(self.label)" />
									<menu id="pp2About" label="About">
										<menupopup>
											<menuitem label="About ZK"
												onClick="alert(self.label)" />
											<menuitem label="About Potix"
												onClick="alert(self.label)" />
											<menu label="others">
												<menupopup>
													<menuitem label="About theme"
														onClick="alert(self.label)" />
													<menuitem label="About addon"
														onClick="alert(self.label)" />
												</menupopup>
											</menu>
											<menu id="pp2Menu" label="Menu">
												<menupopup>
													<menu id="pp2ColorPicker" label="Color Picker" content="#color=#029BCB">
														<attribute name="onChange"><![CDATA[
															win1.setContentStyle("background-color:" + event.value);
														]]></attribute>
													</menu>
												</menupopup>
											</menu>
										</menupopup>
									</menu>
								</menupopup>
							</combobutton>
						</hbox>
    					<separator></separator>
						<menubar id="menubar" width="100%">
							<menu label="Project" image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
								<menupopup>
									<menuitem image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png" label="New"
										onClick="alert(self.label)" />
									<menuitem image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png" label="Open"
										onClick="alert(self.label)" />
									<menuitem image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png" label="Save"
										onClick="alert(self.label)" />
									<menuseparator />
									<menuitem label="Exit" image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png" onClick="alert(self.label)" />
								</menupopup>
							</menu>
							<menu label="Help" id="mbHelp" image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
								<menupopup>
									<menuitem label="Index" onClick="alert(self.label)" />
									<menu label="About" id="mbAbout">
										<menupopup>
											<menuitem label="About ZK"
												onClick="alert(self.label)" />
											<menuitem label="About Potix"
												onClick="alert(self.label)" />
										</menupopup>
									</menu>
								</menupopup>
							</menu>
							<menu image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
								<menupopup>
									<menuitem label="Index" onClick="alert(self.label)" />
									<menu label="Color Picker" content="#color=#184dc6"/>
								</menupopup>
							</menu>
						</menubar>
						<checkbox label="auto drop" id="cbx">
							<attribute name="onCheck">
								bd.setAutodrop(self.checked);
								bd2.setAutodrop(self.checked);
							</attribute>
						</checkbox>
						<hbox>
							<button label="change child" onClick="">
								<attribute name="onClick">
									Component a = ppOne;
									Component b = ppTwo;
									Component pa = ppOne.getParent();
									Component pb = ppTwo.getParent();
									ppOne.setParent(null);
									ppTwo.setParent(null);
									a.setParent(pb);
									b.setParent(pa);
								</attribute>
							</button>
							<button label="change image">
								<attribute name="onClick">
									String i1 = bd.getImage();
									String i2 = bd2.getImage();
									if (i2 == null) {
										bd.setImage("img/coffee.gif");
										bd2.setImage("img/circle.png");
									} else {
										bd.setImage(i2);
										bd2.setImage(i1);
									}
								</attribute>
							</button>
							<button label="open combobutton one">
								<attribute name="onClick">
									bd.setOpen(true);
								</attribute>
							</button>
							<button label="open combobutton two">
								<attribute name="onClick">
									bd2.setOpen(true);
								</attribute>
							</button>
						</hbox>
					</vbox>
				</window>
			</zk>

    """

    runZTL(zscript,
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

        def clickAndWait(wgt: org.zkoss.ztl.ClientWidget) {
          click(wgt);
          waitResponse();
        }
        def clickAndCheck (wgt: org.zkoss.ztl.ClientWidget, cnt: Array[String], box: Array[Widget]) {
          clickAndWait(wgt);

          for (i <- 0 until cnt.length) {
            verifyTrue("Should has this message: "+cnt(i),
                box(i).$n().get("value").contains(cnt(i)));
          }
        }
        def openMenu (wgts: Array[String]) {
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
        openMenu(Array(".z-menu:contains(About)"));
        clickAndWait(jq(".z-label:contains(message box)"));
        // step 8
        clickAndCheck(jq(bd2).toWidget().$n("btn"),
            Array("combobutton two opened"),
            Array(messageBox));
        
        // to avoid click 'Help' menu 
        clickAt(jq(".z-button:contains(change image)"), "2,2")
        waitResponse()
        
        openMenu(Array(pp2About, pp2Menu, pp2ColorPicker));
        verifyTrue("Color picker should opened",
            jq(".z-colorpalette-popup").is(":visible"));
        
        // to avoid click 'Help' menu, reset
        clickAt(jq(".z-button:contains(image)"), "2,2")
        waitResponse()

        // step 9
        clickAndCheck(jq(bd).toWidget().$n("btn"),
            Array("combobutton one opened"),
            Array(messageBox));
        verifyTrue("combobutton one should opened",
            jq(ppOne.$n()).is(":visible"));
        clickAndWait(li);
        verifyFalse("combobutton one should opened",
            jq(ppOne.$n()).is(":visible"));

//		  selenium problem
//        clickAndWait(cbx.$n("real"));
//        
//        click(jq(bd2).toWidget().$n("btn"))
//        openMenu(Array(pp2About, pp2Menu, pp2ColorPicker));
//        verifyTrue("Color picker should opened",
//            jq(".z-colorpalette-popup").is(":visible"));
    }
   );
  }
}