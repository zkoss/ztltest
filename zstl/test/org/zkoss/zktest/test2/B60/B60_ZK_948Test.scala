/* B60_ZK_948Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Apr 19 14:23:53 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-948
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-948.zul,B,E,Selectbox")
class B60_ZK_948Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<div>1. Click on the 'Do modal' button.</div>
				<div>2. Check selectbox has data. Select some value. Close the window.</div>
				<div>3. Click on the 'Do modal' button again. Window should be displayed. Check selectbox has data and the selected value.</div>
				<div>4. Close the window.</div>
				<div>5. Click on the 'move to first window' button, the selectbox should appear after the 'Do modal' button.</div>
				<div>6. Check selectbox has data and the selected value.</div>
				<div>7. Click on the 'move to second window' button, the selectbox should appear below the 'Do modal' button.</div>
				<div>8. Check selectbox has data and the selected value.</div>
				<div>9. Click on the 'attach to page directly' button, the selectbox should appear after the 'attach to page directly' button.</div>
				<div>10. Check selectbox has data and the selected value.</div>
    			<label id="lb1" value="lb1" />
				<zscript><![CDATA[
					//@IMPORT
					import org.zkoss.zk.ui.event.EventListener;
					//@DECLARATION
					Window win = null;
    				Label lb2 = null;
					Selectbox selBox = null;
					public class MyListener implements EventListener{
						public void onEvent(Event evt) throws Exception{
							if (win == null) {
								String[] userName = { "Tony", "Ryan", "Jumper", "Wing", "Sam" };
								ListModelList model = new ListModelList(userName);
								selBox = new Selectbox();
								selBox.setModel(model);
    							selBox.setId("sbx");
    							lb2 = new Label();
    							lb2.setId("lb2");
    							lb2.setValue("lb2");
								win = new Window();
								win.setTitle("Hello!");
								win.setClosable(true);
								win.appendChild(lb2);
    							win.appendChild(selBox);
							} 
				       
							win.setParent(mainWindow);
							win.doModal();
						}
					}
				]]></zscript>
				<window id="mainWindow">
					<button id="btn1">Do modal
						<attribute name="onCreate">
							self.addEventListener("onClick", new MyListener(){});
						</attribute>
					</button>
				</window>
				<window id="secondWindow">
			
				</window>
				<button id="btn2">move to modal window
					<attribute name="onClick">
						if (selBox != null) {
							selBox.setParent(win);
							lb2.setParent(win);
						}
					</attribute>
				</button>
				<button id="btn3">move to first window
					<attribute name="onClick">
						if (selBox != null)
							selBox.setParent(mainWindow);
					</attribute>
				</button>
				<button id="btn4">move to second window
					<attribute name="onClick">
						if (selBox != null)
							selBox.setParent(secondWindow);
					</attribute>
				</button>
				<button id="btn5">attach to page directly
					<attribute name="onClick">
						selBox.setParent(null);
						selBox.setPage(mainWindow.getPage());
					</attribute>
				</button>
			</zk>

    """

    runZTL(zscript,
      () => {
        var sbx: Widget = engine.$f("sbx");
        var lb1: Widget = engine.$f("lb1");
        var lb2: Widget = engine.$f("lb2");
        var btn1: Widget = engine.$f("btn1");
        var btn2: Widget = engine.$f("btn2");
        var btn3: Widget = engine.$f("btn3");
        var btn4: Widget = engine.$f("btn4");
        var btn5: Widget = engine.$f("btn5");

        def selectItem(sbx: Widget, lb: Widget, idx: Int) {
          select(sbx, "Tony")
        }

        def checkSelbox() {
          verifyTrue("Select box has items",
            jq(sbx).find("option").length() == 5);
        }

        click(btn1);
        waitResponse();
        selectItem(sbx, lb2, 0);
        checkSelbox();
        click(jq(".z-window-modal").toWidget().$n("close"));
        waitResponse();

        click(btn1);
        waitResponse();
        checkSelbox();
        click(jq(".z-window-modal").toWidget().$n("close"));
        waitResponse();

        click(btn3);
        waitResponse();
        checkSelbox();
        click(btn4);
        waitResponse();
        checkSelbox();
        click(btn5);
        waitResponse();
        checkSelbox();

      }
    );
  }
}