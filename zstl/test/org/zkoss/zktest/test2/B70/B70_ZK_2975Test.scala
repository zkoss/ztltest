package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2975.zul")
class B70_ZK_2975Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val dateboxInput = jq(".z-datebox-input");
        `type`(dateboxInput, "mars 2015");

        waitResponse(true);
        
        val errorbox = jq(".z-errorbox");
        
        verifyFalse(errorbox.is(":visible"));
      })

  }
}