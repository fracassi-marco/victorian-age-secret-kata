# Victorian Age Secrets Kata

## Section 1: Mr. Blue, Mr. Pink & Mr. Brown

```java
talksWith("Mr. Blue","Mr. Pink")
secrets("Mr. Blue","Gossip1")
ask("Mr. Blue") == "Gossip1"
ask("Mr. Pink") == ""
propagate()
ask("Mr. Pink") == "Gossip1"
ask("Mr. Blue") == ""
```

```java
talksWith("Mr. Blue","Mr. Brown")
secrets("Mr. Blue","Gossip2")
propagate()
ask("Mr. Pink") == "Gossip2"
ask("Mr. Brown") == ""
ask("Mr. Blue") == "Gossip2"
propagate()
ask("Mr. Brown") == "Gossip2"
ask("Mr. Blue") == ""
ask("Mr. Pink") == ""
secrets("Mr. Blue", "Gossip3")
propagate()
ask("Mr. Pink") == "Gossip3"
secrets("Mr. Blue", "Gossip4")
propagate()
ask("Mr. Pink") == "Gossip4"
ask("Mr. Brown") == ""
```

## Section 2: Lady Violet

```java
talksWith("Lady Violet","Mr. Blue")
talksWith("Lady Violet","Mr. Brown")
secrets("Lady Violet", "Gossip5")
propagate()
ask("Mr. Blue") == "Gossip5"
ask("Mr. Brown") == "Gossip5"
ask("Lady Violet") == ""
```

## Section 3: the Doctor

```java
talksWith("Dr. Black","Mr. Blue")
talksWith("Dr. Black","Mr. Pink")
secrets("Dr. Black", "Gossip6")
propagate()
ask("Mr. Blue") == "Gossip6"
ask("Mr. Pink") == ""
secrets("Dr. Black", "Gossip7")
propagate()
ask("Mr. Pink") == "Gossip6"
propagate()
ask("Mr. Blue") == "Gossip7"
```

## Section 4: Sir

```java
talksWith("Sir Grey","Dr. Black")
secrets("Sir Grey", "Gossip8")
propagate()
ask("Dr. Black") == ""
ask("Sir Grey") == "Gossip8"
```