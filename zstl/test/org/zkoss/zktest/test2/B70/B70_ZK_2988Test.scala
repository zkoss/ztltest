package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2988.zul")
class B70_ZK_2988Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<grid onCreate='Clients.evalJavaScript("done()")'>
		<columns>
			<column label="Col 1" hflex="min" />
			<column label="Col 2" hflex="1" />
			<column label="Col 3" hflex="1" />
			<column label="Col 4" hflex="1" />
		</columns>
		<rows>
			<row>
				<label value="1" />
				<label value="2" />
				<label value="3" />
				<label value="4" />
			</row>
		</rows>
		<foot>
			<footer label="1" span="2"/>
			<footer label="3" />
			<footer label="4" />
		</foot>
	</grid>
	<script type="text/javascript">
		function done() {
			document.body.setAttribute("done", "true");
		}
	</script>
</zk>

    """

    runZTL(zscript,
      () => {
        val done = jq("body").attr("done");
        verifyEquals(done, "true");
      })

  }
}