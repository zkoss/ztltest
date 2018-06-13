/* B60_ZK_827Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Feb 16 09:47:46 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{ClientWidget, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug ZK-827
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-827.zul,A,E,Listbox,ListModel,Selection,Checkmark")
class B60_ZK_827Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<window>
					<label multiline="true">
					1.click sim1,sim2,sim3 to select these 3 item.
					2.click single, you should see only one item is selected (which one is selected depends on hash code)
					3.click another other item, the selection should change to clicked item.
					
					</label>
					<zscript><![CDATA[
					org.zkoss.zul.ListModelList lml1 = new org.zkoss.zul.ListModelList();
					for(int i=0;i<10;i++){
						lml1.add(""+i);
					}
					
					void simbind(){
						if(true) return;
						//to sim zkbind sequence, you can ignore this method, just check sim1 ..etc
						Object[] arr = lml1.getSelection().toArray();
						lml1.clearSelection();
						
						for(Object obj:arr){
							lml1.addToSelection(obj);
						}
					}
					
					void sim1(){
						lml1.addToSelection("1");
						lml1.clearSelection();
						lml1.addToSelection("1");
					}
					void sim2(){
						lml1.addToSelection("2");
						lml1.clearSelection();
						lml1.addToSelection("1");
						lml1.addToSelection("2");
					}
					void sim3(){
						lml1.addToSelection("3");
						lml1.clearSelection();
						lml1.addToSelection("1");
						lml1.addToSelection("2");
						lml1.addToSelection("3");
					}
					void single(){
						listbox.setMultiple(false);
					}
					void showSelection(){
						msg.setValue(""+listbox.getModel().getSelection());
					}
					
					]]></zscript>
					<listbox id="listbox" model="${lml1}" checkmark="true" multiple="true" onSelect="//simbind()">
					
					</listbox>
					<button id="btnOne" label="sim1" onClick='sim1()'/>
					<button id="btnTwo" label="sim2" onClick='sim2()'/>
					<button id="btnThree" label="sim3" onClick='sim3()'/>
					<button id="btnFour" label="single" onClick='single()'/>
					<button id="btnFive" label="show selection" onClick='showSelection()'/>
					<label id="msg" />
				</window>
			</zk>

    """
    runZTL(zscript,
      () => {
        var msg: Widget = engine.$f("msg");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var btnThree: Widget = engine.$f("btnThree");
        var btnFour: Widget = engine.$f("btnFour");
        var btnFive: Widget = engine.$f("btnFive");
        def clickAndWait(wgt: ClientWidget) {
          click(wgt);
          waitResponse();
        }

        clickAndWait(btnOne);
        clickAndWait(btnTwo);
        clickAndWait(btnThree);
        clickAndWait(btnFour);
        clickAndWait(btnFive);

        var index: Int = parseInt(msg.$n().get("innerHTML").trim().replace("[", "").replace("]", ""));
        verifyTrue("select should sync between client and server",
          jq(".z-listitem-selected:contains(" + index + ")").exists());
        clickAndWait(jq(".z-listitem").get(6));
        clickAndWait(btnFive);
        index = parseInt(msg.$n().get("innerHTML").trim().replace("[", "").replace("]", ""));
        verifyTrue("select should sync between client and server",
          jq(".z-listitem-selected:contains(" + index + ")").exists());

      }
    );
  }
}