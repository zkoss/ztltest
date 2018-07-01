package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2473.zul")
class B70_ZK_2473Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<zk>
	<label multiline="true">
		According to zhtml's lang.xml, it can recognize zhtml, htm, html, and xhtml file type.
		So the include component should be instant mode for this case.
	</label>
	<include src="/test2/B70-ZK-2473_include.xhtml" />
</zk>

"""
    runZTL(zscript,
      () => {
        var label = jq("label > span").first();

        verifyContains(label.text(), "Included content")

      })

  }
}