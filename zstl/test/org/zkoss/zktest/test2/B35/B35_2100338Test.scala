/* B35_2100338Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element


/**
 * A test class for bug 2100338
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2100338.zul,A,E,Listbox")
class B35_2100338Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>
<window title="Live Data Demo" border="normal">	
	<html><![CDATA[  
	1.click listbox model 1,listbox model 2 , the label in listbox should change without any error<br/>
	2.go to last page of listbox,click listbox model 1,listbox model 2 , the label in listbox should change without any error<br/>
	3.click grid model 1,grid model 2 , the label in grid should change without any error<br/>
	3.go to last page of grid,click grid model 1,grid model 2 , the label in grid should change without any error<br/>
	
	]]></html>
	<zscript><![CDATA[  
		String[] data1,data2;
		data1 = new String[55];
		for(int j=0; j<data1.length; ++j) {
			data1[j] = "A option "+j;
		}
		data2 = new String[65];
		for(int j=0; j<data2.length; ++j) {
			data2[j] = "B option "+j;
		}
		ListModel model1 = new ListModelList(data1);
		ListModel model2 = new ListModelList(data2);
		
	]]></zscript>	
	<hbox>

	<button id="lm1" onClick="lb1.setModel(model1);" label="listbox model 1"/>
	<button id="lm2" onClick="lb1.setModel(model2)" label="listbox mode 2"/>
	<button id="gm1" onClick="gd1.setModel(model1);" label="grid model 1"/>
	<button id="gm2" onClick="gd1.setModel(model2)" label="grid mode 2"/>
	</hbox> 
	<hbox>
	<listbox id="lb1" width="400px" model="${model1}" mold="paging" pageSize="10" >
		<listhead>
			<listheader label="listbox" sort="auto"/>
		</listhead>
	</listbox>
	<grid id="gd1" width="400px" model="${model1}" mold="paging" pageSize="10" >
		<columns>
			<column label="grid"/>
		</columns>
	</grid>
	</hbox>
</window>


    """

    runZTL(zscript,
        () => {
        	
            waitResponse();
            var lm1=jq("$lm1");
            var lm2=jq("$lm2");
            var gm1=jq("$gm1");
            var gm2=jq("$gm2");
            
            var lm_last=jq("[name=" + jq("$lb1").find(".z-paging").attr("id") + "-last]");
            var gm_last=jq("[name=" + jq("$gd1").find(".z-paging").attr("id") + "-last]");
            
            //1 - click List Model 1
        	click(lm1);
        	waitResponse();
        	
        	//click List Model 2
        	click(lm2);
        	waitResponse();
        	
        	//Verify no error
            verifyFalse(jq(".z-messagebox-error").exists());
            verifyFalse(jq(".z-error").exists());
        	
        	//Label change
        	var a=jq(".z-listcell");
        	for (i <- 0 until a.length()) {
        		var vl=a.eq(i).text();
        		verifyEquals(vl,"B option "+i);
        	}
        	
        	//2 - goto last page
        	click(lm_last);
        	waitResponse();
        	
        	//click List Model 1 button
        	click(lm1);
        	waitResponse();
        	
        	//Verify no error
            verifyFalse(jq(".z-messagebox-error").exists());
            verifyFalse(jq(".z-error").exists());
        	
        	//Label change 
        	a=jq(".z-listcell");
        	for (i <- 0 until a.length()) {
        	    var i1=i+50;
        		var vl=a.eq(i).text();
        		verifyEquals(vl,"A option "+i1);
        	}
        	
        	//click List Model 2 button
        	click(lm2);
        	waitResponse();
        	
        	//Verify no error
            verifyFalse(jq(".z-messagebox-error").exists());
            verifyFalse(jq(".z-error").exists());
        	
        	//Label change
        	a=jq(".z-listcell");
        	for (i <- 0 until a.length()) {
        	    var i1=i+50;
        		var vl=a.eq(i).text();
        		verifyEquals(vl,"B option "+i1);
        	}
        	
        	//3 - click Grid Model 1
        	click(gm1);
        	waitResponse();
        	
        	//click Grid Model 2
        	click(gm2);
        	waitResponse();
        	
        	//Verify no error
            verifyFalse(jq(".z-messagebox-error").exists());
            verifyFalse(jq(".z-error").exists());
        	
        	//Label change
        	var b=jq(".z-row .z-label");
        	for (i <- 0 until b.length()) {
        		var vl=getText(b.eq(i));
        		var v1=("B option "+i);
        		verifyEquals(vl,v1);
        	}
        	
        	//4 - goto last page
        	click(gm_last);
        	waitResponse();
        	
        	//click Grid Model 1 button
        	click(gm1);
        	waitResponse();
        	
        	//Verify no error
            verifyFalse(jq(".z-messagebox-error").exists());
            verifyFalse(jq(".z-error").exists());
        	
        	//Label change 
        	b=jq(".z-row .z-label");
        	for (i <- 0 until b.length()) {
        	    var i1=i+50;
        		var vl=getText(b.eq(i));
        		verifyEquals(vl,"A option "+i1);
        	}
        	
        	//click Grid Model 2 button
        	click(gm2);
        	waitResponse();
        	
        	//Verify no error
            verifyFalse(jq(".z-messagebox-error").exists());
            verifyFalse(jq(".z-error").exists());
        	
        	//Label change
        	b=jq(".z-row .z-label");
        	for (i <- 0 until b.length()) {
        	    var i1=i+50;
        		var vl=getText(b.eq(i));
        		verifyEquals(vl,"B option "+i1);
        	}
                   
        }
    );
   }
}
