package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{NonConcurrent, Tags}

@Tags(tags = "B70-ZK-2980.zul")
@NonConcurrent
class B70_ZK_2980Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val saveButton = jq("button:contains(save)");
        click(saveButton);

        waitResponse(true);

        val editButton = jq("button:contains(edit)");
        verifyTrue(editButton.eq(0).is(":focus"));
      })

  }
}