/* B36_3049167Test.scala

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
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 3049167
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-3049167.zul,A,E,Listbox,Grid,DragDrop")
class B36_3049167Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {

      //Listbox
      waitResponse();

      //Get element ZK Forge
      //Get element ZK GWT
      var item0 = jq(".z-listbox-body .z-listcell:eq(0)");
      var item2 = jq(".z-listbox-body .z-listcell:eq(2)");

      waitResponse();

      var pos = item2.positionLeft() + "," + item2.positionTop();

      dragAndDrop(item0, pos);

      waitResponse();

      var info = jq(".z-listbox .z-paging-info");
      var infotxt = getText(info);
      var original = "[ 1 - 5 / 8 ]";

      //Verify qty
      verifyEquals(infotxt, original);

      //Grid
      waitResponse();

      //Get element ZK Forge
      //Get element ZK GWT
      var item01 = jq(".z-grid .z-label:eq(0)");
      var item12 = jq(".z-grid .z-label:eq(2)");

      waitResponse();

      dragAndDrop(item01, pos);

      waitResponse();

      var info1 = jq(".z-grid .z-paging-info");
      var infotxt1 = getText(info1);
      var original1 = "[ 1 - 5 / 8 ]";

      //Verify qty
      verifyEquals(infotxt1, original1);

    });
  }

}