import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F51-ZK-237TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F51-ZK-237TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?import org.zkoss.zktest.test2.*?>
			<?import org.zkoss.zul.*?>
			<?import org.zkoss.zktest.test2.F327Init?>
			<?import org.zkoss.zktest.test2.*?>
			<?import java.lang.*?>
			
			<?init class="F327Init"?>
			<?variable-resolver class="F327Resolver"?>
			<?function-mapper class="F327Mapper"?>
			<?xel-method prefix="c" name="forName"
				class="Class"
				signature="Class forName(String)"?>
			
			<window border="normal" apply="F327Composer" use="Window">
				If you saw this page, it runs correctly.
				<separator/>
				<button id="hi" label="hi"/>
				\${resolver}
				<separator/>
				\${c:forName(\'java.util.List\')}
			</window>`,
	);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(
						".z-label:contains(If you saw this page, it runs correctly.)",
					)[0],
			)(),
		)
		.ok("Page should displayed correctly");
});
