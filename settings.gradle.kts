rootProject.name = "layering-example"

include(
  "bounded-context-1:feature-slice-1:application",
  "bounded-context-1:feature-slice-1:domain",
  "bounded-context-1:feature-slice-1:infrastructure:persistence"
)