package wooteco.subway.line.domain;

import java.util.List;

import wooteco.subway.station.domain.Station;

public class Line {
    private Long id;
    private String name;
    private String color;
    private int extraFare;
    private Sections sections = new Sections();

    public Line() {
    }

    public Line(String name, String color) {
        this(null, name, color, 0, new Sections());
    }

    public Line(String name, String color, int extraFare) {
        this(null, name, color, extraFare, new Sections());
    }

    public Line(Long id, String name, String color, int extraFare) {
        this(id, name, color, extraFare, new Sections());
    }

    public Line(Long id, String name, String color, int extraFare, Sections sections) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.extraFare = extraFare;
        this.sections = sections;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getExtraFare() {
        return extraFare;
    }

    public Sections getSections() {
        return sections;
    }

    public void update(Line line) {
        this.name = line.getName();
        this.color = line.getColor();
    }

    public void addSection(Station upStation, Station downStation, int distance) {
        Section section = new Section(upStation, downStation, distance);
        sections.addSection(section);
    }

    public void addSection(Section section) {
        if (section == null) {
            return;
        }
        sections.addSection(section);
    }

    public void removeSection(Station station) {
        sections.removeStation(station);
    }

    public List<Station> getStations() {
        return sections.getStations();
    }

    public boolean isIncludingStation(Long id) {
        return getStations().stream()
                            .map(Station::getId)
                            .anyMatch(it -> it.equals(id));
    }
}
