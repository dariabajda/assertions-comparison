# Failed validation messages
## JUnit 5
### Compare multiple properties
```
Multiple Failures (3 failures)
	org.opentest4j.AssertionFailedError: expected: <false> but was: <true>
	org.opentest4j.AssertionFailedError: expected: <tekst> but was: <inny tekst>
	org.opentest4j.AssertionFailedError: expected: <[a, b]> but was: <[x, y, z]>
```
### Compare objects
```
expected: <SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b])> but was: <SomeObject(booleanProperty=false, stringProperty=inny tekst, listProperty=[x, y, z])>
Expected :SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b])
Actual   :SomeObject(booleanProperty=false, stringProperty=inny tekst, listProperty=[x, y, z])
```

## AssertJ
### Compare multiple properties
```
Multiple Failures (3 failures)
-- failure 1 --
Expecting value to be false but was true
at AssertJSpec.assertj - compare properties(AssertJSpec.java:15)
-- failure 2 --
expected: "inny tekst"
 but was: "tekst"
at AssertJSpec.assertj - compare properties(AssertJSpec.java:16)
-- failure 3 --
expected: ["x", "y", "z"]
 but was: ["a", "b"]
at AssertJSpec.assertj - compare properties(AssertJSpec.java:17)
```
### Compare objects
```
Expecting actual:
  SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b])
to be equal to:
  SomeObject(booleanProperty=false, stringProperty=inny tekst, listProperty=[x, y, z])
when recursively comparing field by field, but found the following 3 differences:

field/property 'booleanProperty' differ:
- actual value  : true
- expected value: false

field/property 'listProperty' differ:
- actual value  : ["a", "b"]
- expected value: ["x", "y", "z"]
actual and expected values are collections of different size, actual size=2 when expected size=3

field/property 'stringProperty' differ:
- actual value  : "tekst"
- expected value: "inny tekst"
```

## assertk
### Compare multiple properties
```
The following assertions failed (3 failures)
	org.opentest4j.AssertionFailedError: expected [booleanProperty] to be false
	org.opentest4j.AssertionFailedError: expected [stringProperty]:<"[inny ]tekst"> but was:<"[]tekst">
	org.opentest4j.AssertionFailedError: expected [listProperty]:<["[x", "y", "z]"]> but was:<["[a", "b]"]>
```
### Compare objects
```
The following assertions failed (3 failures)
	org.opentest4j.AssertionFailedError: expected [booleanProperty]:<[fals]e> but was:<[tru]e> (SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b]))
	org.opentest4j.AssertionFailedError: expected [listProperty]:<["[x", "y", "z]"]> but was:<["[a", "b]"]> (SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b]))
	org.opentest4j.AssertionFailedError: expected [stringProperty]:<"[inny ]tekst"> but was:<"[]tekst"> (SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b]))
```

## Kotest
### Compare multiple properties
```
The following 3 assertions failed:
1) expected:<false> but was:<true>
	at KotestSpec.kotest - compare properties(KotestSpec.kt:16)
2) expected:<"inny tekst"> but was:<"tekst">
	at KotestSpec.kotest - compare properties(KotestSpec.kt:17)
3) Element differ at index: [0, 1]
Missing elements from index 2
expected:<["x", "y", "z"]> but was:<["a", "b"]>
	at KotestSpec.kotest - compare properties(KotestSpec.kt:18)
```
### Compare objects
```
data class diff for model.SomeObject
├ booleanProperty: expected:<false> but was:<true>
├ stringProperty: expected:<"inny tekst"> but was:<"tekst">
└ listProperty: Element differ at index: [0, 1]
Missing elements from index 2
expected:<["x", "y", "z"]> but was:<["a", "b"]>
```


## Spock

### Compare multiple properties
```
Multiple Failures (3 failures)
	org.spockframework.runtime.ConditionNotSatisfiedError: Condition not satisfied:

!it.booleanProperty
||  |
||  true
|SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b])
false

	org.spockframework.runtime.SpockComparisonFailure: Condition not satisfied:

it.stringProperty == "inny tekst"
|  |              |
|  tekst          false
|                 5 differences (50% similarity)
|                 (-----)tekst
|                 (inny )tekst
SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b])

	org.spockframework.runtime.SpockComparisonFailure: Condition not satisfied:

it.listProperty == ["x", "y", "z"]
|  |            |
|  [a, b]       false
SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b])
```
### Compare objects
```
Condition not satisfied:

actual == expected
|      |  |
|      |  SomeObject(booleanProperty=false, stringProperty=inny tekst, listProperty=[x, y, z])
|      false
SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b])

	at SpockSpec.spock - compare objects(SpockSpec.groovy:24)
```

## Strikt
### Compare multiple properties
```
▼ Expect that true:
  ✗ is false
    found true
▼ Expect that "tekst":
  ✗ is equal to "inny tekst"
          found "tekst"
▼ Expect that ["a", "b"]:
  ✗ is equal to ["x", "y", "z"]
          found ["a", "b"]
```
### Compare objects
```
▼ Expect that SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b]):
  ✗ is equal to SomeObject(booleanProperty=false, stringProperty=inny tekst, listProperty=[x, y, z])
          found SomeObject(booleanProperty=true, stringProperty=tekst, listProperty=[a, b])
```
