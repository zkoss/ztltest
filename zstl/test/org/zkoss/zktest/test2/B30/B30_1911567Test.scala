/* B30_1911567Test.scala

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
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 1911567
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B30-1911567.zul,A,E,Listbox,Listhead")
class B30_1911567Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
    		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
    			<n:p>You should see two headers below "name" and "gender".</n:p>
    			<listbox width="250px">
    				<listhead sizable="true">
    					<listheader label="name" sort="auto"/>
    					<listheader label="gender" sort="auto"/>
    				</listhead>
    			</listbox>
    		</zk>
    """

    runZTL(zscript,
      () => {

        waitResponse();

        //Name header
        val name = jq("@listheader:eq(0)");

        //Gender header
        val gender = jq("@listheader:eq(1)");

        //Verify name header exists
        verifyTrue(name.exists());

        //Verify gender header exists
        verifyTrue(gender.exists());

        val nameText = getText(jq("@listheader:eq(0)")).trim;
        verifyEquals(nameText, "name");

        val genderText = getText(jq("@listheader:eq(1)")).trim;
        verifyEquals(genderText, "gender");

      }
    );
  }
}
