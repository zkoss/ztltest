package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2980.zul")
class B70_ZK_2980Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val saveButton = jq("button:contains(save)");
        click(saveButton);
        
        waitResponse();
        
        val editButton = jq("button:contains(edit)");
        verifyTrue(editButton.eq(0).is(":focus"));
      })

  }
}