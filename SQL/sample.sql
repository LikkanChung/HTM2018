INSERT INTO `htmstory`.`story`
(`StoryID`,
`Name`,
`Creator`)
VALUES
(100,'My First Sample Story','MyUsername');

INSERT INTO `htmstory`.`part`
(`PartID`,
`Title`,
`Body`,
`ParentID`,
`StoryID`)
VALUES
(101,
'The first part of the story',
'I can go either to part 2 or 3',
NULL,
100);

INSERT INTO `htmstory`.`part`
(`PartID`,
`Title`,
`Body`,
`ParentID`,
`StoryID`)
VALUES
(102,
'The second part of the story',
'I can go either to part 4 or 5',
101,
100);

INSERT INTO `htmstory`.`part`
(`PartID`,
`Title`,
`Body`,
`ParentID`,
`StoryID`)
VALUES
(103,
'The third part of the story',
'I can go either to part 6 or 7',
101,
100);

INSERT INTO `htmstory`.`part`
(`PartID`,
`Title`,
`Body`,
`ParentID`,
`StoryID`)
VALUES
(104,
'The fourth part of the story',
'Here I end',
102,
100);

INSERT INTO `htmstory`.`part`
(`PartID`,
`Title`,
`Body`,
`ParentID`,
`StoryID`)
VALUES
(105,
'The fifth part of the story',
'Here I end',
102,
100);

INSERT INTO `htmstory`.`part`
(`PartID`,
`Title`,
`Body`,
`ParentID`,
`StoryID`)
VALUES
(106,
'The sixth part of the story',
'Here I end',
103,
100);

INSERT INTO `htmstory`.`part`
(`PartID`,
`Title`,
`Body`,
`ParentID`,
`StoryID`)
VALUES
(107,
'The seventh part of the story',
'Here I end',
103,
100);