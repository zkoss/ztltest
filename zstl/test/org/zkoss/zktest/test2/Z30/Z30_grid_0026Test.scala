/* Z30_grid_0026Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 17:32:45 CST 2011 , Created by TonyQ
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.junit.Test

/**
 * A test class for bug grid-0026
 * @author TonyQ
 *
 */
@Tags(tags = "Z30-grid-0026.zul,Z30,B,E,Grid,IE")
class Z30_grid_0026Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk>
			The update of list cell freeze IE.<separator/>
			
			You can update/add/remove the grid via timer, and the browser window should not be frozen. (IE only)
			
			<window title="test Grid" height="500px" contentStyle="overflow:auto;width:800px;height:400px;position:relative" border="normal">
				
				<zscript><![CDATA[
				
					String[] testArr = new String[30];
					for(int i=0;i<30;i++)
						testArr[i] = "s"+i;
						
					void updateCell(){
						c11.setValue("c11:"+new java.util.Date());
						ckk.setValue("ckk"+new java.util.Date());
					}
					
					void removeRow(){
						lb.rows.getChildren().remove(1);
					}
					
					void addRow(){
						Row item = new Row();
						new Label(""+(System.currentTimeMillis()>>>3)).setParent(item);
						new Label("A1").setParent(item);
						new Label("A2").setParent(item);
						new Label("A3").setParent(item);
						new Label("A4").setParent(item);
						new Label("A5").setParent(item);
						new Label("A6").setParent(item);
						new Label("A7").setParent(item);
						new Label("A8").setParent(item);
						new Label("A9").setParent(item);
						
						lb.rows.getChildren().add(lb.rows.getChildren().size() - 1,item);
					}
				
				
				]]></zscript>
				<button id="btnStart" label="start timer" onClick="timer.start()"/>
				<button id="btnStop" label="stop timer" onClick="timer.stop()"/>
				| <checkbox id="update" checked="true" />Update | <checkbox id="add" />Add |
				<checkbox id="remove"/>Remove (stop at last 3 rows)
				<timer id="timer" delay="1500" repeats="true" running="false">
					<attribute name="onTimer"><![CDATA[
						if (update.checked)
							updateCell();
						if(add.checked){
							addRow();
						}
						if(remove.checked && lb.rows.getChildren().size()>3){
							removeRow();
						}
					]]></attribute>
				</timer>
				
				
				<grid id="lb">
					<columns sizable="true">
						<column label="Col 0"/>
						<column label="L-col 1" align="left"/>
						<column label="C-col 2" align="center"/>
						<column label="R-col 3" align="right"/>
						<column label="Col 4"/>
						<column label="Col 5"/>
						<column label="Col 6"/>
						<column label="Col 7"/>
						<column label="Col 8"/>
						<column label="Col 9"/>
					</columns>
					<rows>
						<row>
						    <label value="0" id="c11"/>
							<label value="1"/>
							<label value="2"/>
							<label value="3"/>
							<label value="4"/>
							<label value="5"/>
							<label value="6"/>
							<label value="7"/>
							<label value="8"/>
							<label value="9"/>
						</row>
						<row forEach="${testArr}">
							<label value="${each}.0"/>
							<label value="${each}.1"/>
							<label value="${each}.2"/>
							<label value="${each}.3"/>
							<label value="${each}.4"/>
							<label value="${each}.5"/>
							<label value="${each}.6"/>
							<label value="${each}.7"/>
							<label value="${each}.8"/>
							<label value="${each}.9"/>			
						</row>
						<row>
							<label value="0"/>
							<label value="1"/>
							<label value="2"/>
							<label value="3"/>
							<label value="4"/>
							<label value="5"/>
							<label value="6"/>
							<label value="7"/>
							<label value="8"/>
							<label value="9" id="ckk"/>
						</row>
					</rows>
				</grid>
			
			
			</window>
			
			
			
			</zk>

    }

    runZTL(zscript,
        () => {
        verifyEquals(jq("@row").length.toString(),"32");
        
        verifyEquals(jq("@row:eq(0) @label:eq(0)").text(),"0");
        
        
        click(widget("$add").$n("real"));
        verifyTrue(widget("$add").is("checked"));
        click(jq("$btnStart"));
        
        sleep(3200);
        
        val amount = jq("@row").length;
        click(widget("$add").$n("real"));
        click(widget("$remove").$n("real"));
        
        verifyFalse(widget("$add").$n("real").is("checked"));
        verifyTrue(widget("$remove").$n("real").is("checked"));
        
        verifyNotEquals(jq("@row:eq(0) @label:eq(0)").text(),"0");
        
        sleep(3200);
        
        
        click(jq("$btnStop"));
        waitResponse;
        val newamount = jq("@row").length;
        verifyTrue(newamount < amount);
        sleep(1700);
        
        verifyTrue( newamount == jq("@row").length );
        
    }
   );
  }
}