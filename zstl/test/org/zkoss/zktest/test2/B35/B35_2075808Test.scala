/* B35_2075808Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 7, 2012 12:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2075808.zul,B,E,Window,Button")
class B35_2075808Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      // Record size proportions of the panels
      val previousProportioncLef = jq("$cLef").width().toDouble / jq("$cLay").width().toDouble;
      val previousProportioncMid = jq("$cMid").width().toDouble / jq("$cLay").width().toDouble;
      val previousProportioncRig = jq("$cRig").width().toDouble / jq("$cLay").width().toDouble;

      // Click on first button
      click(engine.$f("modify"));
      waitResponse();

      // Click on second button
      click(engine.$f("remove"));
      waitResponse();

      // Record new size proportions of the panels
      val lastProportioncLef = jq("$cLef").width().toDouble / jq("$cLay").width().toDouble;
      val lastProportioncMid = jq("$cMid").width().toDouble / jq("$cLay").width().toDouble;
      val lastProportioncRig = jq("$cRig").width().toDouble / jq("$cLay").width().toDouble;

      // Verify that the new proportions are equals than previously
      verifyEquals("The proportion must be equal than before the clicks", previousProportioncLef, lastProportioncLef);
      verifyEquals("The proportion must be equal than before the clicks", previousProportioncMid, lastProportioncMid);
      verifyEquals("The proportion must be equal than before the clicks", previousProportioncRig, lastProportioncRig);
    })
  }
}