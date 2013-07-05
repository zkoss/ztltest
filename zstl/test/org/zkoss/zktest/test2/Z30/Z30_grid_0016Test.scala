/* Z30_grid_0016Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 15:33:31 CST 2011 , Created by TonyQ
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z30

import scala.collection.mutable.ListBuffer

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.util.Scripts
import org.zkoss.ztl.Tags

/**
 * A test class for bug grid-0016
 * @author TonyQ
 *
 */
@Tags(tags = "Z30-grid-0016.zul,Z30,A,E,Grid,Row")
class Z30_grid_0016Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript ="""
			<window>
			<vbox>
				Empty grid:
				<grid id="gd" mold="paging"/>
			             <hbox>
				<button id="btnAddRows" label="1. Click me to add rows only once" onClick="new Rows().setParent(gd)"/>
				<button id="btnAddRow" label="2. Click me to add row" onClick="addgd(1)"/>
			<zscript><![CDATA[
				void addgd(int cnt) {
					for (int j = 0; ++j <= cnt;) {
						Row r = new Row();
						String prefix = "Item " + (gd.getRows().getChildren().size() + 1);
						new Label(prefix + "-L").setParent(r);
						new Label(prefix + "-C").setParent(r);
						new Label(prefix + "-R").setParent(r);
						r.setParent(gd.getRows());
					}
				}
				]]>
			</zscript>
			             </hbox>
			</vbox>
			</window>

	""";
      
    runZTL(zscript,
        () => {
	        def clickThenValidate(selector:String,validator:()=>Unit ){
	          	Scripts.triggerMouseEventAt(getWebDriver(), jq(selector), "click", "2,2")        
	        	waitResponse()
	        	validator()
	        }          
	        def verifyRowContent(iterator:Iterator[String]) ={
		        val verify = iterator;
		        val list =  jq("@row").iterator();
		        while(list.hasNext()){
		          val row = list.next() ;
		          var text = verify.next();
				  verifyEquals(row.find(".z-label:first").text(),text);
				}          
	        }          
        verifyEquals(jq("@rows").length.toString(),"0");
        verifyEquals(jq("@row").length.toString(),"0");
        
        clickThenValidate("$btnAddRows",()=>{
        	verifyEquals(jq("@rows").length.toString(),"1");
        	verifyEquals(jq("@row").length.toString(),"0");
        });

        	
		val list = new ListBuffer[String]
        for (i <- 1 until 21) {
          	list += "Item "+i+"-L"
          	
	        clickThenValidate("$btnAddRow",()=>{
	        	verifyEquals(jq("@rows").length.toString(),"1");
	        	verifyEquals(jq("@row").length.toString(),""+i);
	        	verifyRowContent(list.iterator)
	        });
        }
        
        clickThenValidate("$btnAddRow",()=>{
        	verifyEquals(jq("@rows").length.toString(),"1");
        	verifyEquals(jq("@row").length.toString(),"20"); //paging
        	verifyRowContent(list.iterator)
        });        

        clickThenValidate("$btnAddRow",()=>{
        	verifyEquals(jq("@rows").length.toString(),"1");
        	verifyEquals(jq("@row").length.toString(),"20"); //paging
        	verifyRowContent(list.iterator)
        });                
        
        clickThenValidate("[name=" + jq(".z-paging").attr("id") + "-next]",()=>{
        	verifyEquals(jq("@rows").length.toString(),"1");
        	verifyEquals(jq("@row").length.toString(),"2"); //paging
        	verifyRowContent(Iterator("Item 21-L","Item 22-L"));
        });          
        
        
        
    }
   );
  }
}