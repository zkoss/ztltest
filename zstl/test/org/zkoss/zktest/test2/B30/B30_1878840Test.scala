/* B30_1878840Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 15, 2011 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.junit.Test

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-1878840.zul,B,E,Window,Button")
class B30_1878840Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript = {
      <zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <n:p>You can scroll down the listbox to end, and then click the listheader to sort the live data.</n:p>
        <n:p>Then you should't see that the content containing some empty content.</n:p>
        <window title="Live Data Demo" border="normal">
    	  <script><![CDATA[
    		function doScrollDown() {
    			var $jq = jq(zk.Widget.$('$list').$n('body'));
    			$jq.scrollTop($jq[0].scrollHeight);
    			return true;
    		}
    	  ]]></script>
          <zscript><![CDATA[
            List items = new org.zkoss.zktest.test2.BigList(100);
    		ListModel strset = new ListModelList(items);
    		ListitemRenderer render = new ListitemRenderer(){
              public void render(Listitem item, Object data, int index) {
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
              }
            }
            ;
          ]]></zscript>
          <listbox id="list" width="400px" rows="20" model="&#36;{strset}" itemRenderer="${render}">
            <listhead sizable="true">
              <listheader label="Col 1" sort="auto"/>
              <listheader label="Col 2" sort="auto"/>
              <listheader label="Col 3" sort="auto"/>
              <listheader label="Col 1" sort="auto"/>
              <listheader label="Col 2" sort="auto"/>
              <listheader label="Col 3" sort="auto"/>
            </listhead>
          </listbox>
        </window>
      </zk>
    }
    runZTL(zscript, () => {

      var $jq = jq(engine.$f("list").$n("body"));
      
      // fix Firefox driver issue
      getEval("doScrollDown()");
     // $jq.scrollTop($jq.scrollHeight());
      waitResponse();

    /* The costly option: 
      var i = 0;
      val count = 100;

      // Loop 100 times to scroll down in the listbox
      while (i < count) {
        // Option 1 (Works on FF and Chrome)
        // NOTE: Sometimes Chrome gives an error, because it can't to process the response
        click(jq(".z-listcell:contains(col - " + i + ")").get(0));

        // Option 2 (doesn't work on Chrome because of a ChromeDriver bug:
        //        http://sqa.stackexchange.com/questions/2023/webdriver-api-failed-to-send-keys-because-cannot-focus-element-better-work
        // The idea here is to scroll with the cursor by pressing the down key (40)
        //        keyPress(jq(".z-listcell").toLocator(), "\\40");
        i += 1;
      }
     */

      // Click on the first header to sort
      click(jq(".z-listheader").get(0));
      waitResponse();

      // Twice to see the ordering
      click(jq(".z-listheader").get(0));
      waitResponse();

      verifyFalse(jq(".z-listcell:empty").get(0).exists());
    })
  }
}