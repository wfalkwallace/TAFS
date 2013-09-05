TAFS
====
###TellApart Practice Challenge: Object Oriented File System

The assignment is to design and implement an in­memory file system. Choose whatever OO language you are comfortable with – preferably Java or Python. And there is no time limit on this search either.

This file­system consists of 4 types of entities: Drives, Folders, Text files, Zip files.

These entities, very much like their “real” file­system counterparts, obey the following relations.

- A folder, a drive or a zip file, may contain zero to many other folders, or files (text or zip).
- A text file does not contain any other entity.
- A drive is not contained in any entity.
- Any non­drive entity must be contained in another entity.

If entity A contains entity B then we say that A is the parent of B. 

Every entity has the following properties:

- Type – The type of the entity (one of the 4 type above).
- Name ­ An alphanumeric string. Two entities with the same parent cannot have the same name. Similarly, two drives cannot have the same name.
- Path – The concatenation of the names of the containing entities, from the drive down to and including the entity. The names are separated by ‘\’.
- A text file has a property called Content which is a string.
- Size – an integer defined as follows:
	- For a text file – it is the length of its content.
	- For a drive or a folder, it is the sum of all sizes of the entities it contains.
	- For a zip file, it is one half of the sum of all sizes of the entities it contains.

The system should be capable of supporting file­system like operations

- Create – Creates a new entity.
	- Arguments: Type, Name, Path of parent.
	- Exceptions: Path not found; Path already exists; Illegal File System Operation (if any of the rules a­d above is violated).
- Delete – Deletes an existing entity (and all the entities it contains).
	- Arguments: Path
	- Exceptions: Path not found.
- Move – Changing the parent of an entity.
	- Arguments: Source Path, Destination Path.
	- Exceptions: Path not found; Path already exists, Illegal File System Operation.
- WriteToFile – Changes the content of a text file.
	- Arguments: Path, Content
	- Exceptions: Path not found; Not a text file.

###Tasks:

- [ x ] Come up with the design for this system. Full implementation is not required, but only to the level which you feel is a “proof of concept”.
- [ x ] Show a sketch of implementation of the Move operation.
- [ x ] Explicitly implement the property Size.

---

#####Lessons Learned:
1. Probably would've been much easier to make a tree/graph and an _element_ object with a type _attribute_; it would get rid of all of the class.forName junk. It would've been easier to traverse and check path validity also. Next episode of code golf…
2. Might have been useful to implement equals/hashcode/comparable by name and cut a loop from each of the searches; that would simplify the traversal/search as well, cutting down on conditionals.
