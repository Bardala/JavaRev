# File Organization Guide

This document shows how to organize existing files from the repository into the chapters structure.

## Recommended File Moves

### Chapter 1: Java Basics

**Source Location**: Root directory  
**Destination**: `chapters/Chapter01-JavaBasics/`

```
Move these files:
- Operators.java → Chapter01-JavaBasics/Operators.java
- Main.java → Chapter01-JavaBasics/Main.java (if basics-related)

From ControlFlow/ folder:
- BreakStatement.java → Chapter01-JavaBasics/BreakStatement.java
- DoWhile.java → Chapter01-JavaBasics/DoWhile.java
- ForLoop.java → Chapter01-JavaBasics/ForLoop.java
```

### Chapter 2: Object-Oriented Programming

**Source Location**: `OOP/` directory  
**Destination**: `chapters/Chapter02-ObjectOrientedProgramming/`

```
Move entire OOP/ folder contents:
- OOP/Constructor.java
- OOP/Student.java
- OOP/inheritance/
- OOP/polymorphism/
- OOP/abstraction/
```

### Chapter 3: Data Structures

**Source Location**: `array/` directory  
**Destination**: `chapters/Chapter03-DataStructures/`

```
Move array/ folder:
- array/ArrayMethods.java
- array/ArrayListMethods.java
- array/Main.java
- array/problems/ArrayProblems.java
```

### Chapter 4: Collection Framework

**Source Location**: `collectionFramework/` directory  
**Destination**: `chapters/Chapter04-CollectionFramework/`

```
Move collectionFramework/ folder:
- collectionFramework/CollectionInterface.java
- collectionFramework/Java_Collection_Framework.md
- collectionFramework/list/
- collectionFramework/set/
- collectionFramework/map/
```

### Chapter 5: String Handling

**Source Location**: `string/` directory  
**Destination**: `chapters/Chapter05-StringHandling/`

```
Move string/ folder:
- string/Main.java
- string/problems/StringProblems.java
```

### Chapter 7: Input/Output

**Source Location**: `javaio/` directory  
**Destination**: `chapters/Chapter07-InputOutput/`

```
Move javaio/ folder:
- javaio/FileStream.java
- javaio/Main.java
```

### Chapter 8: Serialization and Immutability

**Source Locations**: Multiple  
**Destination**: `chapters/Chapter08-SerializationAndImmutability/`

```
Move these files:
- immutableClass.java → Chapter08-SerializationAndImmutability/
- OOP/Serialization.java → Chapter08-SerializationAndImmutability/
- serializeKeyWord/Employee.java → Chapter08-SerializationAndImmutability/
```

### Chapter 12: Algorithms and Problem Solving

**Source Location**: `programs/` directory  
**Destination**: `chapters/Chapter12-AlgorithmsAndProblemSolving/`

```
Move programs/ folder:
- programs/BubbleSort.java
- programs/Fibonacci.java
- programs/ReverseLinkedList.java

Move from root:
- leetcode.java → Chapter12-AlgorithmsAndProblemSolving/

Move string problems:
- string/problems/StringProblems.java → Chapter12-AlgorithmsAndProblemSolving/problems/

Move array problems:
- array/problems/ArrayProblems.java → Chapter12-AlgorithmsAndProblemSolving/problems/
```

## Documentation Files

### Move docs to appropriate chapters:

```
docs/Access Modifier.md
→ Chapter02-ObjectOrientedProgramming/docs/AccessModifier.md

docs/AssociationAggregationComposition.md
→ Chapter02-ObjectOrientedProgramming/docs/AssociationAggregationComposition.md

docs/clone method.md
→ Chapter02-ObjectOrientedProgramming/docs/CloneMethod.md

collectionFramework/Java_Collection_Framework.md
→ Chapter04-CollectionFramework/docs/CollectionFramework.md
```

## Implementation Steps

### Option 1: Manual Organization (Recommended for learning)

1. Create backup of root directory
2. Manually move files to chapter folders
3. Update any import statements if needed
4. Test files run correctly in new locations

### Option 2: Using Command Line

```powershell
# Copy files instead of move (safer)
Copy-Item -Path .\Operators.java -Destination .\chapters\Chapter01-JavaBasics\Operators.java
Copy-Item -Path .\OOP -Destination .\chapters\Chapter02-ObjectOrientedProgramming\ -Recurse
# ... continue for other folders
```

### Option 3: Keep Both Locations

- Keep original files in root for reference
- Create example files in chapter folders
- This is safer and maintains backward compatibility

## File Naming Convention for New Files

When adding files to chapters, use clear naming:

```
✅ Good:
- ExceptionBasics.java
- GenericBox.java
- ThreadExample.java
- SortingAlgorithms.java

❌ Avoid:
- ExceptionTest.java (unclear)
- GenericExample2.java (unclear numbering)
- Thread.java (conflicts with built-in class)
- Sort.java (too generic)
```

## Notes

- **Original Repository**: Keep `operators/`, `array/`, `OOP/`, etc. as reference
- **Chapter Structure**: New primary learning path in `chapters/`
- **No Forced Migration**: Existing files stay in place; chapters are additions
- **Progressive Adoption**: Gradually move/organize files as you learn
- **Backup First**: Always backup before moving files

---

**Recommendation**: Start by exploring the chapter READMEs and keeping original files in place. As you progress, you can organize files into chapters for cleaner structure.
