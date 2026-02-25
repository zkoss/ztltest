import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F65-ZK-1269TestCafe`
	.page`http://localhost:8080/zktest/test2/F65-ZK-1269.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F65-ZK-1269TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq(".z-button:contains(change orient):eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(next):eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.wait(500);
	await t.expect("false").ok("should show component 10.");
	await t.click(Selector(() => jq(".z-button:contains(previous):eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.wait(500);
	await t.expect("false").ok("should show component 9.");
	await t.click(
		Selector(() => jq(".z-button:contains(append component):eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("1 1");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Go)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 11.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("9");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Go)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 9.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(insert)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(insert)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t
		.pressKey("9")
		.click(Selector(() => jq(".z-button:contains(Add)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-button:contains(show selected index)")[0]),
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("should show selected index 10.");
	await t.click(
		Selector(() => jq(".z-messagebox-window .z-button:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("1 2");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Remove)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 9.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("9");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Remove)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 10.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("9");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Go)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 9.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("2");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Remove)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 10.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-button:contains(show selected index)")[0]),
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("should show selected index 9.");
	await t.click(
		Selector(() => jq(".z-messagebox-window .z-button:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("9");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Remove)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 9.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-button:contains(show selected index)")[0]),
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("should show selected index 8.");
	await t.click(
		Selector(() => jq(".z-messagebox-window .z-button:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("2");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Go)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 3.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("7");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Remove)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 3.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("7");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Go)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 9.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("0");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Go)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 0.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("0");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Remove)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 1.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("6");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Go)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 9.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Go)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-hlayout:contains(Go)").find(".z-intbox")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("5");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Remove)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect("false").ok("should show component 9.");
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-hlayout:contains(Remove)").find(".z-intbox"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(".z-hlayout:contains(Remove)").find(".z-intbox")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-button:contains(show selected index)")[0]),
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("should show selected index 5.");
	await t.click(
		Selector(() => jq(".z-messagebox-window .z-button:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
});
