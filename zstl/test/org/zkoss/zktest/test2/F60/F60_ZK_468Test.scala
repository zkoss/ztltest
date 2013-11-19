/* F60_ZK_468Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 16:47:21 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

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
 * A test class for bug ZK-468
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-468.zul,F60,A,E,Selectbox,Databinding,Model")
class F60_ZK_468Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>
			<zk>
			        <zscript>
			                <![CDATA[
			 
			        public class MyUserBean{
			                private String[] userList = { "Tony", "Ryan", "Jumper", "Wing", "Sam" };
			                private int index = 0;
			                public ListModelList getUserList(){
			                        return new ListModelList(Arrays.asList(userList));
			                }
			                public void setUserList(){
			                }
			                public void setIndex(int ind){
			                        index=ind;
			                }
			                public int getIndex(){
			                        return index;
			                }
			                public String getCurrentName(){
			                        return userList[index];
			                }
			        }
			         
			        MyUserBean mybean = new MyUserBean();
			 
			        org.zkoss.zul.ItemRenderer render = new org.zkoss.zul.ItemRenderer() {
			 
			                public String render(Component owner, Object data) throws Exception {
			                        return data.toString();
			                }
			        };
			]]></zscript>
			 Please select each of the item in the dropdown list and the label below should be changed as your selection 
			        <div>
    				<label id="outer" value="outer" />
			        Select User:
			        <selectbox id="box" model="@{mybean.userList}"
			                selectedIndex="@{mybean.index}">
			                <template name="model">
			                ${each}
			                </template>
			        </selectbox>
			 
			        </div>
			        Selected:
			        <label id="val" value="@{mybean.currentName }" />
			</zk>

    """

    runZTL(zscript,
        () => {
        var outer: Widget = engine.$f("outer");
        var box: Widget = engine.$f("box");
        var _val: Widget = engine.$f("val");

        def selectItem (content: String) {
          select(box, content);
          click(outer);
          waitResponse();
          verifyTrue("the label below should be changed as your selection",
              _val.$n().get("innerHTML").equals(content));
        }
        selectItem("Tony");
        selectItem("Ryan");
        selectItem("Jumper");
        selectItem("Wing");
        selectItem("Sam");
    }
   );
  }
}