![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# Starlit_One: An Astronomical Catalog Application

## Description of the project

This backend application project creates a simple astronomical catalog of star patterns such as constellations and asterisms.

- A star pattern is a constellation or a group of stars (IUA, 2024)
- A constellation is an official or defined star pattern (International Astronomical Union (IUA, 1930)
- An asterism is an unofficial sub-pattern within a constellation or unofficial pattern that overlaps constellations (IUA, 2024)

The project has SQL tables, a parent class, inherited classes, interfaces, services, controller, and repository testing. 

Some caveats:

Only spring and summer phenomena were considered for this project. These constellations and asterisms manifest in the northern hemisphere. These star patterns are disjoint to simplify table structuring.

<br>

## Class Diagram

<br>

## Setup

For this project, there are two implemented database tables. The database data represents true information for a simple astronomical catalog.

### Star Pattern

| id | name            | description         | discovery_period | pattern_type  | main_star_count | 
| -- | --------------- | ------------------- | ---------------- | ------------- | --------------- |
| 1  | Canes Venatici  | The hunting dogs    | Modern           | Constellation | 3               |
| 2  | Sagitta         | The arrow           | Ancient          | Constellation | 4               |
| 3  | Septentrio      | Seven plough oxen   | Ancient          | Asterism      | 7               |
| 4  | Summer Triangle | The summer triangle | Modern           | Asterism      | 3               |
| 5  | Ursa Minor      | The little bear     | Ancient          | Constellation | 7               |

### Stars

| star_id  | name                  | color        | star_type                      | pattern_id | 
| -------- | --------------------- | ------------ | ------------------------------ | ---------- |
| S1       | Cor Caroli            | yellow-white | main-sequence/ variable binary | 1          |
| S2       | Chara                 | yellow       | main sequence                  | 1          |
| S3       | 20 Canum Venaticorum  | yellow-white | giant                          | 1          |
| S4       | Sham                  | yellow       | luminous giant                 | 2          |
| S5       | Beta Sagittae         | yellow       | luminous giant                 | 2          |
| S6       | Gamma Sagittae        | orange-red   | giant                          | 2          |
| S7       | Delta Sagittae        | red          | spectroscopic binary           | 2          |
| S8       | Alioth                | blue-white   | variable                       | 3          |
| S9       | Dubhe                 | blue-white   | spectroscopic binary           | 3          |
| S10      | Alkaid                | blue         | main sequence                  | 3          |
| S11      | Mizar                 | blue-white   | spectroscopic binary           | 3          |
| S12      | Megrez                | blue-white   | main sequence                  | 3          |
| S13      | Phecda                | blue-white   | main sequence                  | 3          |
| S14      | Merak                 | blue-white   | main sequence                  | 3          |
| S15      | Altair                | blue-white   | subgiant                       | 4          |
| S16      | Deneb                 | blue-white   | evolved supergiant             | 4          |
| S17      | Vega                  | blue-white   | main sequence                  | 4          |
| S18      | Polaris               | yellow-white | Multiple star system           | 5          |
| S19      | Kochab                | orange-red   | variable giant                 | 5          |
| S20      | Pherkad               | blue-white   | giant                          | 5          |
| S21      | Yildun                | blue-white   | main sequence                  | 5          |
| S22      | Epsilon Ursae Minoris | yellow       | giant                          | 5          |
| S23      | Akhfa Al Farkadain    | blue-white   | variable                       | 5          |
| S24      | Anwar Al Farkadain    | yellow-white | main sequence                  | 5          |

<br>

## Used Technologies

<br>

## Controllers and Routes structure

<br>

## Extra links(Trello, Presentation Slides, etc…)

<br>

## Future Work

<br>

## Resources


References: 

https://www.iau.org/public/themes/constellations/

https://www.universeguide.com/blogarticle/list-of-constellations-ordered-by-main-star-count-smallest-to-largest

https://www.constellation-guide.com/big-dipper/

<br>

## Team members

<br>
